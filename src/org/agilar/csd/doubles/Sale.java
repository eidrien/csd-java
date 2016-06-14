package org.agilar.csd.doubles;


public interface Sale {
	String getIdentifier();
	void addProduct(Product product, int quantity);
	void popProduct(Product product);
	void Total();
	double getTotal();
	String getInvoiceIdentifier();
}
