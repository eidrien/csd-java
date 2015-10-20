package org.agilar.csd.unitTesting;

public class Calculator {
	
	private int value;
	
	public Calculator(){
		value = 0;
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
