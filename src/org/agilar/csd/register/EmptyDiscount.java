package org.agilar.csd.register;

public class EmptyDiscount implements Discount {

	@Override
	public int getDiscount() {
		return 0;
	}

	@Override
	public void addElementforDiscount(Fruit fruit) {
	}

	

}
