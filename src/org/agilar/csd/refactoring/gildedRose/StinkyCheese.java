package org.agilar.csd.refactoring.gildedRose;

public class StinkyCheese extends ItemThatImprovesWithAge {

	public static final String AGED_BRIE = "Aged Brie";

	public StinkyCheese(int sellIn, int quality){
		super(AGED_BRIE, sellIn, quality);
	}
	
	public void updateQuality() {
		if (sellInDateHasCome() && hasQualityBelow50()) {
			incrementQualityByOne();
		}
		super.updateQuality();
	}
}
