package org.agilar.csd.mocks;

public interface EmailsService {


	void sendInvoice(Invoices invoice, String email);
	boolean anInvoiceWasSent();
}
