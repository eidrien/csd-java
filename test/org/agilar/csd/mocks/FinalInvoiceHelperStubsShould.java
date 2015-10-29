package org.agilar.csd.mocks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FinalInvoiceHelperStubsShould {

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
 
	public void PrepareStubsOKInvoicesSenders()
	{
		printerService = new StubPrinterSenderOk();
		emailService = new StubEmailExchangeServiceOK();
		finalInvoiceStep = new FinaliceInvoice(printerService, emailService);
		
	}

	public void PrepareStubsKOInvoicesSenders()
	{
		printerService = new StubPrinterSenderKO();
		emailService = new StubEmailExchangeServiceKO();
		finalInvoiceStep = new FinaliceInvoice(printerService, emailService);
		
	}
	
	@Test
	public void SendEmailFailInvoiceToCustomer() {
		
		PrepareStubsKOInvoicesSenders();
		customer.setIfWantEmailInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertFalse("Nothing should be printed email", emailService.anInvoiceWasSent());
 
	}
 
	@Test
	public void PrintInvoiceFailToCustomer() {
		PrepareStubsKOInvoicesSenders();
		customer.setIfWantEmailInvoice(false);
        customer.setIfWantPrintInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertFalse("Nothing should be printed",printerService.anInvoiceWasPrinted());
	}
	

	@Test
	public void SendEmailInvoiceToCustomer() {
		PrepareStubsOKInvoicesSenders();
		customer.setIfWantEmailInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertTrue(" Should be printed email", emailService.anInvoiceWasSent());
 
	}
 
	@Test
	public void PrintInvoiceToCustomer() {
		PrepareStubsOKInvoicesSenders();
		customer.setIfWantEmailInvoice(false);
        customer.setIfWantPrintInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertTrue(" Should be printed",printerService.anInvoiceWasPrinted());
	}

}
