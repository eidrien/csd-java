package org.agilar.csd.mocks;

public class DummyEmailExchangeServiceKO implements EmailsService {

	protected boolean anInvoiceWasSent;
	
	@Override
	public void sendInvoice(Invoices invoice, String email) {
		// TODO Auto-generated method stub
		
		//sentEmail
		anInvoiceWasSent = false;
	}

	@Override
	public boolean anInvoiceWasSent() {
		// TODO Auto-generated method stub
		return anInvoiceWasSent;
	}

}
