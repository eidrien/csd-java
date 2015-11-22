package org.agilar.csd.refactoring.gildedRose;

public class RegularItem extends Item {

	public RegularItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		reduceQualityByOneIfPositive();
		if (sellInDateHasCome() ) {
			reduceQualityByOneIfPositive();
		}
		super.updateQuality();
	}
	
}
