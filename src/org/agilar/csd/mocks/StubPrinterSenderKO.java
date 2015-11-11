package org.agilar.csd.mocks;

public class StubPrinterSenderKO implements PrintersService {
	
	boolean anInvoiceWasPrinted = false;
	
	
 	public boolean isPrinterConfigured() {
		return true;
	}

   
	public boolean anInvoiceWasPrinted() {
		return false;
	}



	public void printInvoice(Invoices invoice) {
		// TODO Auto-generated method stub
		anInvoiceWasPrinted = false;
	}
	

}
