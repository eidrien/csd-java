package org.agilar.csd.mocks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FinalInvoiceHelperManualMockShould {

	private FinaliceInvoice finalInvoiceStep = null;
	private Customers customer = null;
	private Invoices invoice = null;
	private PrintersService  printerService = null;
	private EmailsService emailService = null;

 
	@Before
	public void beforeEachTest() {
		customer = new Customer("a@a.com");
		invoice = new Invoice();
	}
 
	public void PrepareMockOKInvoicesSenders()
	{
		printerService = new DummyPrinterSenderOk();
		emailService = new DummyEmailExchangeServiceOK();
		finalInvoiceStep = new FinaliceInvoice(printerService, emailService);
		
	}

	public void PrepareMockKOInvoicesSenders()
	{
		printerService = new DummyPrinterSenderKO();
		emailService = new DummyEmailExchangeServiceKO();
		finalInvoiceStep = new FinaliceInvoice(printerService, emailService);
		
	}
	
	@Test
	public void SendEmailFailInvoiceToCustomer() {
		
		PrepareMockKOInvoicesSenders();
		customer.setIfWantEmailInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertFalse("Nothing should be printed email", emailService.anInvoiceWasSent());
 
	}
 
	@Test
	public void PrintInvoiceFailToCustomer() {
		PrepareMockKOInvoicesSenders();
		customer.setIfWantEmailInvoice(false);
        customer.setIfWantPrintInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertFalse("Nothing should be printed",printerService.anInvoiceWasPrinted());
	}
	

	@Test
	public void SendEmailInvoiceToCustomer() {
		PrepareMockOKInvoicesSenders();
		customer.setIfWantEmailInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertTrue(" Should be printed email", emailService.anInvoiceWasSent());
 
	}
 
	@Test
	public void PrintInvoiceToCustomer() {
		PrepareMockOKInvoicesSenders();
		customer.setIfWantEmailInvoice(false);
        customer.setIfWantPrintInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertTrue(" Should be printed",printerService.anInvoiceWasPrinted());
	}

}
