package org.agilar.csd.unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrangeActAssert {

	Calculator calculator;
	
	// Tests Should have three separate parts: Arrange-Act-Assert / Given-When-Then
	// Arrange/Given: 
	// - The data used in a test should not depend on the environment in which the test is running. 
	// - All the data needed for a test should be arranged as part of the test.
	// - No asserts to be executed in this step
	// Act/When: 
	// - Invoke the actual method under test.
	// - There should be a single action.
	// Assert/Then: 
	// - A test method should test for a single logical outcome, implying that typically there should be only a single logical assert. 
	// - A logical assert could have multiple physical asserts a long as all the asserts test the state of a single object. 
	// - In a few cases, an action can update multiple objects.

	
	@Test
	public void calculatorShouldInitializeWithZero(){
		givenFreshCalculator();
		thenCalculatedValueIs(0);
	}

	@Test
	public void addingToAnInitializedCalculatorReturnsAddedValue(){
		int number = 5;
		givenFreshCalculator();
		whenAdding(number);
		thenCalculatedValueIs(number);
	}

	@Test
	public void addingNegativeNumbersSubtracts(){
		int initialNumber = 5;
		int negativeNumber = -2;
		givenCalculatorWithValue(initialNumber);		
		whenAdding(negativeNumber);
		thenCalculatedValueIs(initialNumber - Math.abs(negativeNumber));
	}

	@Test
	public void addingZeroDoesNothing(){
		int initialNumber = 2;
		givenCalculatorWithValue(initialNumber);
		whenAdding(0);
		thenCalculatedValueIs(initialNumber);
	}

	@Test public void addingPastTheMaximumIntegerReturnsNegative(){
		givenCalculatorWithValue(Integer.MAX_VALUE);
		whenAdding(1);
		thenCalculatedValueIs(Integer.MIN_VALUE);
	}
	
	// Helper methods for Given-When-Then
	
	private void givenCalculatorWithValue(int initialNumber) {
		givenFreshCalculator();
		calculator.add(initialNumber);
	}

	private void givenFreshCalculator() {
		calculator = new Calculator();
	}
	
	private void whenAdding(int number) {
		calculator.add(number);
	}
	
	private void thenCalculatedValueIs(int value) {
		assertEquals(value, calculator.getValue());
	}

}
