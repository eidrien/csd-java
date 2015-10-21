package org.agilar.csd.unitTesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterMachine {

	private Calculator calculator;

	private Map<String, Integer> products;
	private List<String> bought;
	
	public RegisterMachine(){
		calculator = new Calculator();
		bought = new ArrayList<String>();
		products = new HashMap<String, Integer>();
		products.put("Apple", 100);
		products.put("Banana", 125);
		products.put("Strawberry", 25);
	}
	
	public void buy(String productName, int quantity){
		for(int i=0; i<quantity; i++){
			bought.add(productName);
			calculator.add(products.get(productName));
		}
	}

	public int getTotalAmount() {
		return calculator.getValue();
	}
}
