package org.agilar.csd.mocks;

public class FinaliceInvoice {
	
	private PrintersService printerService = null;
	private EmailsService emailService = null;
 
	public FinaliceInvoice(PrintersService printerService, EmailsService emailService)
	{
		this.printerService = printerService;
		this.emailService = emailService;
	}
 
	public void handleInvoice(Invoices invoice, Customers customer)
	{
		if(customer.wantEmailInvoice())
		{
			emailService.sendInvoice(invoice,customer.getEmail());
		}
		
		if (customer.wantPrinterInvoice())
		{
			printerService.printInvoice(invoice);
		}
	}
}


