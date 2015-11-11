package org.agilar.csd.mocks;

public class Printer3DService implements PrintersService {

	Invoices invoice = null;

	public void printInvoice(Invoices invoice) {
		// TODO Auto-generated method stub
		this.invoice = invoice;
	}

	public boolean isPrinterConfigured() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean anInvoiceWasPrinted() {
		// TODO Auto-generated method stub
		
		//Enviamos teoricamente con el driver de impresora y devuelve true;
		return true;
	}

}
