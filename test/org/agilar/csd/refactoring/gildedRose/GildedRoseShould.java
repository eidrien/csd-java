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

		GildedRose.updateQuality(items);

		assertEquals(9, items.get(0).sellIn);
		assertEquals(19, items.get(0).quality);
		assertEquals(2, items.get(1).sellIn);
		assertEquals(5, items.get(1).quality);
	}

	@Test
	public void decreasesTheQualityAndTheSellInOfTheProductsTwiceAsFastWhenWeHavePassedTheSellInDate()
			throws Exception {
		items.add(new Item("+5 Dexterity Vest", 0, 20));
		items.add(new Item("Conjured Mana Cake", 0, 6));

		GildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, -1);
		assertEquals(items.get(0).quality, 18);
		assertEquals(items.get(1).sellIn, -1);
		assertEquals(items.get(1).quality, 4);
	}
	
	@Test
	public void qualityIsNeverNegative(){
		items.add(new Item("+5 Dexterity Vest", 10, 0));

		GildedRose.updateQuality(items);

		assertEquals(9, items.get(0).sellIn);
		assertEquals(0, items.get(0).quality);
	}

	@Test
	public void increaseTheQualityByOneOfTheProductsThatGetBetterAsTheyAge() {
		items.add(new Item("Aged Brie", 20, 30));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30));

		GildedRose.updateQuality(items);

		assertEquals(19, items.get(0).sellIn);
		assertEquals(31, items.get(0).quality);
		assertEquals(19, items.get(1).sellIn);
		assertEquals(31, items.get(1).quality);
	}

	@Test
	public void doesNotIncreaseQualityhOver50() throws Exception {
		items.add(new Item("Aged Brie", 3, 50));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50));

		GildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, 2);
		assertEquals(items.get(0).quality, 50);
		assertEquals(items.get(1).sellIn, 19);
		assertEquals(items.get(1).quality, 50);
	}

	@Test
	public void doesNotAlterTheQualityOfSulfurasWhichIsAlways80() throws Exception {
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

		GildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, 0);
		assertEquals(items.get(0).quality, 80);
	}

	@Test
	public void increaseQualityByTwoOfBackstagePassWhenThereAre10daysOrLessLeft() throws Exception {
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30));

		GildedRose.updateQuality(items);

		assertEquals(7, items.get(0).sellIn);
		assertEquals(32, items.get(0).quality);
	}

	@Test
	public void increasesTheQualityByThreeOfBackstagePassWhenThereAre5daysOrLessLeft()
			throws Exception {
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 15));

		GildedRose.updateQuality(items);

		assertEquals(4, items.get(0).sellIn);
		assertEquals(18, items.get(0).quality);
	}

	@Test
	public void updatesTheQualityOfBackstagePassToZeroWhenWeHavePassedTheSellInDate() throws Exception {
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));

		GildedRose.updateQuality(items);

		assertEquals(items.get(0).sellIn, -1);
		assertEquals(items.get(0).quality, 0);
	}

}
