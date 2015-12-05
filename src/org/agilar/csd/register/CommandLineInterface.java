package org.agilar.csd.register;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommandLineInterface {

	public  static void main(String[] args){
		
	    FruitCatalog fruitCatalog = new FruitCatalog();
		Fruit apple = new Fruit("Apples", 100);
		fruitCatalog.addFruit(apple);
		Fruit cherries = new Fruit("Cherries", 75);
		fruitCatalog.addFruit(cherries);
		Fruit bananas = new Fruit("Bananas", 150);
		fruitCatalog.addFruit(bananas);

	    Set<Discount> discounts = new HashSet<Discount>();
		Discount cherryDiscount = new VolumeDiscount(cherries, 2, 20);
		discounts.add(cherryDiscount);
		
	    RegisterMachine machine = new RegisterMachine(fruitCatalog, discounts);

		Scanner scanner = new Scanner(System.in);
	    String input = scanner.next();
	    machine.input(input);
	    System.out.println(machine.getOutput());
	}
}
