package org.agilar.csd.unitTesting;

public class Calculator {
	
	private int value;
	public static int startValue = 0;
	
	public Calculator(){
		value = startValue;
	}

	public void add(int i) {
		value += i;
	}

	public void subtract(int i){
		value -= i;
	}
	
	public void multiplyBy(int i){
		value *= i;
	}
	
	public void divideBy(int i){
		value /= i;
	}
	
	public int getValue(){
		return value;
	}
}
