package org.agilar.csd.doubles;


public interface NotificationService {
	
	void send(Invoice invoice);
	int howManyTimesInvoiceHasBeenSended(Invoice invoice);

}
