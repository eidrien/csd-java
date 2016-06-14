package org.agilar.csd.doubles;

import java.util.Calendar;
import java.util.List;

import org.agilar.csd.doubles.exceptions.*;

public class TPV {
	
	Repository<String,Customer> _customers;
	Repository<String, Product> _products;
	Repository<String,Sale> _historicalSales;
	Repository<String,Sale> _openSales;
	InvoiceService _invoiceService;
	NotificationService _notificationService;
	
	Sale _currentSale;
	Customer _currentCustomer;
	
	public TPV(NotificationService notificationService, InvoiceService invoiceService
			,Repository<String,Sale> historical, Repository<String,Sale> openSales
			,Repository<String,Customer> customers,Repository<String, Product> products) {

		_customers = customers;
		_products = products;
		_notificationService = notificationService;
		_invoiceService = invoiceService;
		_historicalSales = historical;
		_openSales = openSales;
	}
	
	public TPV forCustomer(String Name){
		_currentCustomer = _customers.getById(Name);
		_currentSale = null;
		return this;
	}
	
	public TPV buys() throws NoCustomerAvailableToBuyException{
		if(_currentCustomer == null)
			throw new NoCustomerAvailableToBuyException();
		
		if(_openSales.contains(_currentCustomer.getIdentifier()))
			 _currentSale = _openSales.getById(_currentCustomer.getIdentifier());
		else
			 _currentSale = _openSales.getNew();
		return this;
	}
	
	public TPV product(String productName, int quantity) throws NoCustomerAvailableToBuyException, NoCurrentSaleAvailable{
		if(_currentCustomer == null )
			throw new NoCustomerAvailableToBuyException();
		if(_currentSale == null)
			throw new NoCurrentSaleAvailable();
		Product product = _products.getById(productName);
		_currentSale.addProduct(product, quantity);
		return this;
	}

	public TPV total(){
		_currentSale.Total();
		_historicalSales.add(_currentSale);
		_openSales.remove(_currentSale);
		return this;
	}
	
	public TPV invoice(){
		_invoiceService.generateInvoice(_currentSale,_currentCustomer);
		return this;
	}
	
	public void sendInvoice(){
		Invoice invoice = _invoiceService.getInvoice(_currentSale.getInvoiceIdentifier());
		_notificationService.send(invoice);
	}

	public int resendInvoice(String identifier){
		Invoice invoice = _invoiceService.getInvoice(identifier);
		_notificationService.send(invoice);
		return _notificationService.howManyTimesInvoiceHasBeenSended(invoice);
	}
	
	public List<Invoice> getTodayResume(){
		return _invoiceService.getAllInvoicesByDay(Calendar.DAY_OF_MONTH);
	}

	public String printGrandTotal(){
		double total = 0.0;
		for(Sale sale : _historicalSales.getAll()){
			total+= sale.getTotal();
		}
		return String.format("%10.2f€", total);
	}
	
	public String printOpenSalesTotal(){
		double total = 0.0;
		for(Sale sale : _openSales.getAll()){
			total+= sale.getTotal();
		}
		return String.format("%10.2f€", total);
	}
}
