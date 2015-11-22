package org.agilar.csd.refactoring.gildedRose;

public class NonRegularItem extends Item {

	public NonRegularItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		super.updateQuality();
		if (sellInDateHasCome()) {
			removeAllQuality();
		}
	}
}
