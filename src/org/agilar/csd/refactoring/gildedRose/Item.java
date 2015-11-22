package org.agilar.csd.refactoring.gildedRose;

public abstract class Item {

	public String name;
	public int sellIn;
	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
		
		
	}
	
	public boolean sellInDateHasCome( ) {
		return sellInLessThan(0);
	}

	public boolean sellInLessThan(int days){
		return sellIn < days;
	}

	public void reduceSellInTimeByOne() {
		sellIn = sellIn - 1;
	}

	public boolean hasSomeQuality() {
		return quality > 0;
	}

	public boolean hasQualityBelow50() {
		return quality < 50;
	}

	public void incrementQualityByOne() {
		quality = quality + 1;
	}

	public void reduceQualityByOneIfPositive() {
		if( hasSomeQuality())
			quality = quality - 1;
	}

	public int setQualityTo50() {
		return quality = 50;
	}

	public void removeAllQuality() {
		quality = 0;
	}

	public void reduceSellInTime() {
		reduceSellInTimeByOne();
	}

	public void updateQuality() {
		if (!hasQualityBelow50()){
			setQualityTo50();
		}
	}


}
