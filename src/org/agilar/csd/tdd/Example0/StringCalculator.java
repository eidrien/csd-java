package org.agilar.csd.tdd.Example0;

public class StringCalculator {

	public int Add(String valueAdded) {
		// TODO Auto-generated method stub
		int valueReturned = 0;
		String[] valuesAdded = null;
		if (valueAdded.isEmpty())
			valueReturned = 0;
		else {
			valuesAdded = valueAdded.split(",");
			for (int i = 0; i < valuesAdded.length; i++)
				valueReturned += Utils.convertToNumerOrZero(valuesAdded[i]);
		}
		return valueReturned;
	}
	
	
}
