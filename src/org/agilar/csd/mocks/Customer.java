package org.agilar.csd.mocks;

public class Customer implements Customers {
	
	String emailAdress = "";
	boolean wantEmailInvoice = true;
	boolean wantPrinterInvoice = false;
	
	Customer(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return emailAdress;
	}
	
	@Override
	public boolean wantEmailInvoice()
	{
		return wantEmailInvoice;
	}
	
	
	@Override
	public void setIfWantEmailInvoice(boolean wantEmailInvoice ){
	  this.wantEmailInvoice = wantEmailInvoice;	
	}

	
	
	@Override
	public boolean wantPrinterInvoice() {
		// TODO Auto-generated method stub
		return wantPrinterInvoice;
	}



	@Override
	public void setIfWantPrintInvoice(boolean wantPrintInvoice) {
		// TODO Auto-generated method stub
		this.wantPrinterInvoice = wantPrintInvoice;
	}

}
