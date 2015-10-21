package org.agilar.csd.oop.polymorphism;

import java.util.HashMap;
import java.util.Map;

public class MethodOverload {

	Map<String, Product> productsAvailable;
	Product defaultProduct; 
	
	String productsBought;
	int total;
	
	public MethodOverload(){
		productsAvailable = new HashMap<String, Product>();
		productsAvailable.put("Banana", new Product("Banana", 100));
		productsAvailable.put("Apple", new Product("Apple", 75));
		productsAvailable.put("Strawberry", new Product("Strawberry", 25));
		
		defaultProduct = new Product("ITEM", 50);
		
		productsBought = new String();
		total = 0;
	}
	
	public void buy(String productName){
		Product product = getProductByName(productName);
		productsBought += printLine(product, 1);
		total += product.price;
	}

	private String printLine(Product product, int quantity) {
		return "item: " + product.name + ", qty: " + quantity + ", price: " + product.price + "\n";
	}

	private Product getProductByName(String productName) {
		Product product = productsAvailable.get(productName);
		return product==null?new Product(productName, defaultProduct.price):product;
	}

	public void buy(String productName, int quantity){
		Product product = getProductByName(productName);
		productsBought += printLine(product, quantity);
		total += product.price * quantity;
	}
	
	public void buy(int price){
		Product product = new Product(defaultProduct.name, price);
		productsBought += printLine(product, 1);
		total += product.price;
	}
	
	public void buy(Product product){
		productsBought += printLine(product, 1);
		total += product.price;
	}
	
	public void buy(Product product, int quantity){
		productsBought += printLine(product, quantity);
		total += product.price * quantity;
	}
	
	public class Product {
		public Product(String name, int price) {
			this.name = name;
			this.price = price;
		}
		String name;
		int price;
	}
}

