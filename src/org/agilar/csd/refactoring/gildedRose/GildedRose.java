package org.agilar.csd.refactoring.gildedRose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	public GildedRose() {
		List<Item> items = new ArrayList<Item>();
		items.add(new RegularItem("+5 Dexterity Vest", 10, 20));
		items.add(new StinkyCheese(2, 0));
		items.add(new Sulfuras());
		items.add(new BackstagePass(15, 20));
		items.add(new RegularItem("Elixir of the Mongoose", 5, 7));
		items.add(new RegularItem("Conjured Mana Cake", 3, 6));
		updateQualityAndSellInTime(items);
	}

	public List<Item> updateQualityAndSellInTime(List<Item> items) {
		for (int i = 0; i < items.size(); i++) {
			Item evaluatedItem = items.get(i);
			evaluatedItem.reduceSellInTime();
			evaluatedItem.updateQuality();
		}
		return items;
	}

}