package org.agilar.csd.mocks;

public class StubPrinterSenderOk implements PrintersService {
	
	boolean anInvoiceWasPrinted = false;
	
	
	public boolean isPrinterConfigured() {
		return true;
	}

   
	public boolean anInvoiceWasPrinted() {
		return true;
	}



	public void printInvoice(Invoices invoice) {
		// TODO Auto-generated method stub
		anInvoiceWasPrinted = true;
	}
	

}
