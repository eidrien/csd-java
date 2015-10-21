package org.agilar.csd.oop.dry;

import java.util.HashMap;
import java.util.Map;

public class WithLotsOfRepetitions {

	Map<String, Product> productsAvailable;
	Product defaultProduct; 
	
	String productsBought;
	int total;
	
	public WithLotsOfRepetitions(){
		productsAvailable = new HashMap<String, Product>();
		productsAvailable.put("Banana", new Product("Banana", 100));
		productsAvailable.put("Apple", new Product("Apple", 75));
		productsAvailable.put("Strawberry", new Product("Strawberry", 25));
		
		defaultProduct = new Product("ITEM", 50);
		
		productsBought = new String();
		total = 0;
	}
	
	public void buy(String productName){
		Product product = productsAvailable.get(productName);
		product = product==null?new Product(productName, defaultProduct.price):product;
		productsBought += "item: " + product.name + ", qty: 1, price: " + product.price + "\n";
		total += product.price;
	}

	public void buy(String productName, int quantity){
		Product product = productsAvailable.get(productName);
		product = product==null?new Product(productName, defaultProduct.price):product;
		productsBought += "item: " + product.name + ", qty: " + quantity + ", price: " + product.price + "\n";
		total += product.price * quantity;
	}
	
	public void buy(int price){
		Product product = new Product(defaultProduct.name, price);
		productsBought += "item: " + product.name + ", qty: 1, price: " + product.price + "\n";
		total += product.price;
	}
	
	public void buy(Product product){
		productsBought += "item: " + product.name + ", qty: 1, price: " + product.price + "\n";
		total += product.price;
	}
	
	public void buy(Product product, int quantity){
		productsBought += "item: " + product.name + ", qty: " + quantity + ", price: " + product.price + "\n";
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

