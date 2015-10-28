package org.agilar.csd.oop.dry;

import java.util.HashMap;
import java.util.Map;


public class WithoutRepetition {

	Map<String, Product> productsAvailable;
	Product defaultProduct; 
	
	String productsBought;
	int total;
	
	public WithoutRepetition(){
		productsAvailable = new HashMap<String, Product>();
		addProduct("Banana", 100);
		addProduct("Apple", 75);
		addProduct("Strawberry", 25);
		
		defaultProduct = new Product("ITEM", 50);
		
		productsBought = new String();
		total = 0;
	}
	
	private void addProduct(String name, int price){
		productsAvailable.put(name, new Product(name, price));
	}
	
	public void buy(String productName){
		buy(productName, 1);
	}

	public void buy(String productName, int quantity){
		Product product = getProductByName(productName);
		buy(product, quantity);
	}
	
	public void buy(int price, int quantity){
		Product product = new Product(defaultProduct.name, price);
		buy(product, quantity);
	}
	
	public void buy(int price){
		buy(price, 1);
	}
	
	public void buy(){
		buy(defaultProduct, 1);
	}
	
	public void buy(Product product){
		buy(product, 1);
	}
	
	public void buy(Product product, int quantity){
		productsBought += printLine(product, quantity);
		total += product.price * quantity;
	}
	
	private String printLine(Product product, int quantity) {
		return "item: " + product.name + ", qty: " + quantity + ", price: " + product.price + "\n";
	}

	private Product getProductByName(String productName) {
		Product product = productsAvailable.get(productName);
		return product==null?new Product(productName, defaultProduct.price):product;
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

