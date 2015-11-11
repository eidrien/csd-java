package org.agilar.csd.mocks;

public class Customer implements Customers {
	
	String emailAdress = "";
	boolean wantEmailInvoice = true;
	boolean wantPrinterInvoice = false;
	
	Customer(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return emailAdress;
	}
	
	public boolean wantEmailInvoice()
	{
		return wantEmailInvoice;
	}
	
	
	public void setIfWantEmailInvoice(boolean wantEmailInvoice ){
	  this.wantEmailInvoice = wantEmailInvoice;	
	}

	
	
	public boolean wantPrinterInvoice() {
		// TODO Auto-generated method stub
		return wantPrinterInvoice;
	}



	public void setIfWantPrintInvoice(boolean wantPrintInvoice) {
		// TODO Auto-generated method stub
		this.wantPrinterInvoice = wantPrintInvoice;
	}

}
