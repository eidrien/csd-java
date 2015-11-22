package org.agilar.csd.refactoring.gildedRose;

public abstract class ItemThatImprovesWithAge extends NonRegularItem {

	public ItemThatImprovesWithAge(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		if (hasQualityBelow50()) {
			incrementQualityByOne();
			if (sellInLessThan(6)) {
				incrementQualityByOne();
			}
			if (sellInLessThan(11)) {
				incrementQualityByOne();
			}
		}

		super.updateQuality();
	}
}
