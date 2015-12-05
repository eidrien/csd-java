package org.agilar.csd.register;

public class VolumeDiscount implements Discount {

	Fruit fruit = null;
	int  volumeNumber = 0;
	int  discountPrice = 0;
	int  boughtPieces = 0;
	
	public VolumeDiscount(Fruit fruit, int volumeNumber, int discountPrice){
		if(volumeNumber == 0){
			throw new RuntimeException("Invalid Discount. Volume must be higher than 0");
		}
		this.fruit = fruit;
		this.volumeNumber = volumeNumber;
		this.discountPrice = discountPrice;
	}
	
	@Override
	public int getDiscount() {
		int totalDiscount = 0;
		if (boughtPieces >= volumeNumber)
			totalDiscount = Math.floorDiv(boughtPieces , volumeNumber) * discountPrice;
		return totalDiscount;
		
	}

	@Override
	public void addElementforDiscount(Fruit fruit) {
		if(fruit == this.fruit){
			boughtPieces += 1;
		}
	}

}
