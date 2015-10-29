package org.agilar.csd.mocks;

public class StubPrinterSenderKO implements PrintersService {
	
	boolean anInvoiceWasPrinted = false;
	
	
    @Override
	public boolean isPrinterConfigured() {
		return true;
	}

   
    @Override
	public boolean anInvoiceWasPrinted() {
		return false;
	}



	@Override
	public void printInvoice(Invoices invoice) {
		// TODO Auto-generated method stub
		anInvoiceWasPrinted = false;
	}
	

}
