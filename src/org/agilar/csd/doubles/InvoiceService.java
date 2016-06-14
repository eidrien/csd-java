package org.agilar.csd.doubles;

import java.util.List;

public interface InvoiceService {
	Invoice getInvoice(String identifier);
	void generateInvoice(Sale _currentSale, Customer _currentCustomer);
	List<Invoice> getAllInvoicesByDay(int dayOfMonth);
}
