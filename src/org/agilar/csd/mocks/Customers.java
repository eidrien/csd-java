package org.agilar.csd.mocks;

public interface Customers {

	String getEmail();

	boolean wantEmailInvoice();

	void setIfWantEmailInvoice(boolean wantEmailInvoice);

	boolean wantPrinterInvoice();

	void setIfWantPrintInvoice(boolean wantPrintInvoice);




}
