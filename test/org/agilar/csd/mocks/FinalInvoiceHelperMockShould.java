package org.agilar.csd.mocks;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class FinalInvoiceHelperMockShould {

	private FinaliceInvoice finalInvoiceStep = null;
	private Customers customer = null;
	private Invoices invoice = null;
	private PrintersService  printerService = null;
	private EmailsService emailService = null;

 
	@Before
	public void beforeEachTest() {
		customer = new Customer("a@a.com");
		invoice = new Invoice();
	
		printerService = new Printer3DService();
		emailService = new EmailExchangeService();
		printerService = Mockito.mock(printerService.getClass());
		emailService = Mockito.mock(emailService.getClass());
		finalInvoiceStep = new FinaliceInvoice(printerService, emailService);
	}
 
	public void PrepareMockOKInvoicesSenders()
	{
		
		when(printerService.anInvoiceWasPrinted()).thenReturn(true);
		when(emailService.anInvoiceWasSent()).thenReturn(true);
	  }

	public void PrepareMockKOInvoicesSenders()
	{
		when(printerService.anInvoiceWasPrinted()).thenReturn(false);
		when(emailService.anInvoiceWasSent()).thenReturn(false);
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
	
	@Test
	public void InvoiceToCustomer() {
		PrepareMockOKInvoicesSenders();
		customer.setIfWantEmailInvoice(false);
        customer.setIfWantPrintInvoice(true);
		finalInvoiceStep.handleInvoice(invoice, customer);
		assertTrue(" Should be printed",printerService.anInvoiceWasPrinted());
	}

}
