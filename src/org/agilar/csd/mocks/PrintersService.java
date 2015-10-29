package org.agilar.csd.mocks;

public interface PrintersService {

	

	void printInvoice(Invoices invoice);

	boolean isPrinterConfigured();

	boolean anInvoiceWasPrinted();
  
}
