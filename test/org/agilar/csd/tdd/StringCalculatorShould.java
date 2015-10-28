package org.agilar.csd.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorShould {

	@Test
	public void StringCalculatorShouldbeZeroifisEmpty() {
		StringCalculator stringCalculator = new StringCalculator();
		int valueofSum = stringCalculator.Add("");
		assertEquals(0,valueofSum);
	}

	@Test
	public void StringCalculatorShouldbeSumOneParameter() {
		StringCalculator stringCalculator = new StringCalculator();
		int valueofSum = stringCalculator.Add("1");
		assertEquals(1,valueofSum);
	}
	@Test
	public void StringCalculatorShouldbeSumTwoParameter() {
		StringCalculator stringCalculator = new StringCalculator();
		int valueofSum = stringCalculator.Add("1,2");
		assertEquals(3,valueofSum);
	}
	
	@Test
	public void StringCalculatorShouldbeSumTwoParameterWithFirstNoNumber() {
		StringCalculator stringCalculator = new StringCalculator();
		int valueofSum = stringCalculator.Add("1,a");
		assertEquals(1,valueofSum);
	}
	@Test
	public void StringCalculatorShouldbeSumTwoParameterWithSecondNoNumber() {
		StringCalculator stringCalculator = new StringCalculator();
		int valueofSum = stringCalculator.Add("a,2");
		assertEquals(2,valueofSum);
	}
	
	@Test
	public void StringCalculatorShouldbeSumTwoParameterWithCharacterExtranged() {
		StringCalculator stringCalculator = new StringCalculator();
		int valueofSum = stringCalculator.Add("1\n,2");
		assertEquals(3,valueofSum);
	}
}
