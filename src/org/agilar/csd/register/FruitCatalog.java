package org.agilar.csd.register;

import java.util.HashMap;
import java.util.Map;

public class FruitCatalog {

	Map<String, Fruit> fruitsByName;

	public FruitCatalog() {
		fruitsByName = new HashMap<String, Fruit>();
	}

	public void addFruit(Fruit fruit) {
		fruitsByName.put(fruit.getName(), fruit);
	}

	public Fruit getFruitByName(String fruitName) {
		Fruit selectedFruit = fruitsByName.get(fruitName);
		if (selectedFruit == null)
			return new Fruit(fruitName, 0);
		else
			return selectedFruit;
	}

}
