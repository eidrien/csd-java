package org.agilar.csd.unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExhaustiveTesting {

	@Test
	public void calculatorShouldInitializeWithZero(){
		Calculator calculator = new Calculator();
		assertEquals(0, calculator.getValue());
	}
	
	@Test
	public void addingToAnInitializedCalculatorReturnsAddedValue(){
		Calculator calculator = new Calculator();
		calculator.add(5);
		assertEquals(5, calculator.getValue());
	}
	
	@Test
	public void addingNegativeNumbersSubtracts(){
		Calculator calculator = new Calculator();
		calculator.add(5);
		calculator.add(-2);
		assertEquals(3, calculator.getValue());
	}

	@Test
	public void addingZeroDoesNothing(){
		Calculator calculator = new Calculator();
		calculator.add(0);
		calculator.add(2);
		calculator.add(0);
		calculator.add(0);
		calculator.add(0);
		calculator.add(0);
		calculator.add(0);
		calculator.add(0);
		calculator.add(0);
		assertEquals(2, calculator.getValue());
	}

	@Test public void addingPastTheMaximumIntegerReturnsNegative(){
		Calculator calculator = new Calculator();
		calculator.add(Integer.MAX_VALUE);
		calculator.add(1);
		assertEquals(Integer.MIN_VALUE, calculator.getValue());
	}
}
