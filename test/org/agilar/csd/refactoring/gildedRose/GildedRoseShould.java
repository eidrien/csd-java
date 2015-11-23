package org.agilar.csd.refactoring.gildedRose;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.TestMethod;

public class GildedRoseShould {

	GildedRose gildedRose;
	List<Item> items;

	@Before
	public void setUp() throws Exception {
		gildedRose = new GildedRose();
		items = new ArrayList<Item>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void decreaseBy1TheQualityAndRemainingSellnDaysOfRegularItems() {
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		items = gildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, 9);
		assertEquals(items.get(0).quality, 19);
		assertEquals(items.get(1).sellIn, 2);
		assertEquals(items.get(1).quality, 5);
	}

	@Test
	public void increaseTheQualityByOneOfTheProductsThatGetBetterAsTheyAge() {
		items.add(new Item("Aged Brie", 20, 30));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30));

		items = gildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, 19);
		assertEquals(items.get(0).quality, 31);
		assertEquals(items.get(1).sellIn, 19);
		assertEquals(items.get(1).quality, 31);
	}

	@Test
	public void increaseQualityByTwoOfTheProductsThatGetBetterAsTheyAgeWhenThereAre10daysOrLessLeft() throws Exception {
		items.add(new Item("Aged Brie", 10, 34));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30));

		items = gildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, 9);
		assertEquals(items.get(0).quality, 36);
		assertEquals(items.get(1).sellIn, 7);
		assertEquals(items.get(1).quality, 32);
	}

	@Test
	public void increasesTheQualityByThreeOfTheProductsThatGetBetterAsTheyAge_WhenThereAre5daysOrLessLeft()
			throws Exception {
		items.add(new Item("Aged Brie", 4, 11));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 15));

		items = gildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, 3);
		assertEquals(items.get(0).quality, 14);
		assertEquals(items.get(1).sellIn, 4);
		assertEquals(items.get(1).quality, 18);
	}

	@Test
	public void decreasesTheQualityAndTheSellInOfTheProductsTwiceAsFastWhenWeHavePassedTheSellInDate()
			throws Exception {
		items.add(new Item("+5 Dexterity Vest", 0, 20));
		items.add(new Item("Conjured Mana Cake", 0, 6));

		items = gildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, -1);
		assertEquals(items.get(0).quality, 18);
		assertEquals(items.get(1).sellIn, -1);
		assertEquals(items.get(1).quality, 4);
	}

	@Test
	public void updatesTheQualityOfBackstagePassesAndBrieToZeroWhenWeHavePassedTheSellInDate() throws Exception {
		items.add(new Item("Aged Brie", 0, 20));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));

		items = gildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, -1);
		assertEquals(items.get(0).quality, 0);
		assertEquals(items.get(1).sellIn, -1);
		assertEquals(items.get(1).quality, 0);
	}

	@Test
	public void doesNotAlterTheQualityOfSulfurasWhichIsAlways80() throws Exception {
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

		items = gildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, 0);
		assertEquals(items.get(0).quality, 80);
	}

	@Test
	public void doesNotIncreaseQualityhOver50() throws Exception {
		items.add(new Item("Aged Brie", 3, 50));

		items = gildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, 2);
		assertEquals(items.get(0).quality, 50);
	}
}
