package org.agilar.csd;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonExhaustiveTesting {

	@Test
	public void test_Calculator() {
		Calculator calculator = new Calculator();
		calculator.add(5);
		calculator.subtract(3);
		calculator.multiplyBy(12);
		calculator.add(10);
		calculator.divideBy(2);
		assertEquals(17, calculator.getValue());
	}

}
