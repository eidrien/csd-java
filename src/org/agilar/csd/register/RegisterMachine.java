package org.agilar.csd.register;

import java.util.Set;

public class RegisterMachine {

	String input = null;
	int total = 0;
	FruitCatalog fruitFactory = null;
	Set<Discount> discounts = null;

	public RegisterMachine(FruitCatalog fruitCatalog, Set<Discount> discounts) {
		this.fruitFactory = fruitCatalog;
		this.discounts = discounts;
	}

	public void input(String inputValue) {
		this.input = inputValue;
		Fruit selectedFruit = fruitFactory.getFruitByName(inputValue);
		updateTotal(selectedFruit);
	}

	private void updateTotal(Fruit selectedFruit) {
		total += selectedFruit.getCost();
		for(Discount discount : discounts){
			discount.addElementforDiscount(selectedFruit);
			total -= discount.getDiscount();
		}
	}

	public String getOutput() {
		return input;
	}

	public int getTotalPrice() {
		return total;
	}

}
