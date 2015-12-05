package org.agilar.csd.register;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegisterMachineShould {

	RegisterMachine register = null;

	@Before
	public void setUp() throws Exception {
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
		
	    register = new RegisterMachine(fruitCatalog, discounts);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void PrintsExactlyTheInput() {

		register.input("Something");
		String output = register.getOutput();
		assertEquals("Something", output);
	}

	@Test
	public void OneBananasCostsOneFiftyEuro() {

		register.input("Bananas");
		int totalPrice = register.getTotalPrice();
		assertEquals(150, totalPrice);
	}

	@Test
	public void OneAppleCostsOneEuro() {

		register.input("Apples");
		int totalPrice = register.getTotalPrice();
		assertEquals(100, totalPrice);
	}

	@Test
	public void OneCherriesCostsSeventFivecents() {

		register.input("Cherries");
		int totalPrice = register.getTotalPrice();
		assertEquals(75, totalPrice);
	}

	@Test
	public void ShoppingMoreThanOneFruits() {

		register.input("Cherries");
		register.input("Bananas");
		register.input("Apples");
		int totalPrice = register.getTotalPrice();
		assertEquals(325, totalPrice);
	}

	@Test
	public void ShoppingWithNothing() {

		register.input("");
		int totalPrice = register.getTotalPrice();
		assertEquals(0, totalPrice);
	}

	@Test
	public void ShoppingTwoCherriesandTakeaDiscount() {

		register.input("Cherries");
		register.input("Cherries");
		int totalPrice = register.getTotalPrice();
		assertEquals(130, totalPrice);
	}
}
