package org.agilar.csd.mocks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FinalInvoiceHelperShould {

	private FinaliceInvoice finalInvoiceStep = null;
	private Customers customer = null;
	private Invoices invoice = null;
	private PrintersService  printerService = null;
	private EmailsService emailService = null;
 
	@Before
	public void beforeEachTest() {
		customer = new Customer("a@a.com");
		
		printerService = new Printer3DService();
		emailService = new EmailExchangeService();
		finalInvoiceStep = new FinaliceInvoice(printerService, emailService);
		invoice = new Invoice();
	}
 
	//@Test
	public void SendEmailFailInvoiceToCustomer() {
		customer.setIfWantEmailInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertFalse("Nothing should be printed email", emailService.anInvoiceWasSent());
 
	}
 
	//@Test
	public void PrintInvoiceFailToCustomer() {
		customer.setIfWantEmailInvoice(false);
        customer.setIfWantPrintInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertFalse("Nothing should be printed",printerService.anInvoiceWasPrinted());
	}
	

	@Test
	public void SendEmailInvoiceToCustomer() {
		customer.setIfWantEmailInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertTrue(" Should be printed email", emailService.anInvoiceWasSent());
 
	}
 
	@Test
	public void PrintInvoiceToCustomer() {
		customer.setIfWantEmailInvoice(false);
        customer.setIfWantPrintInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertTrue(" Should be printed",printerService.anInvoiceWasPrinted());
	}

}
