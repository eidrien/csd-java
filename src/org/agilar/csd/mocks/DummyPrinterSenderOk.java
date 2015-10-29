package org.agilar.csd.mocks;

public class DummyPrinterSenderOk implements PrintersService {
	
	boolean anInvoiceWasPrinted = false;
	
	
    @Override
	public boolean isPrinterConfigured() {
		return true;
	}

   
    @Override
	public boolean anInvoiceWasPrinted() {
		return true;
	}



	@Override
	public void printInvoice(Invoices invoice) {
		// TODO Auto-generated method stub
		anInvoiceWasPrinted = true;
	}
	

}
