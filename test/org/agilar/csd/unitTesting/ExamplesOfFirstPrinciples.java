package org.agilar.csd.unitTesting;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExamplesOfFirstPrinciples {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/////////////////// FAST //////////////////////
	@Test
	public void hundredsOfTestsShouldRunPerMinute() {
		Date startTime = new Date();
		assertEquals(1, 1);
		Date endTime = new Date();
		long elapsedTime = endTime.getTime() - startTime.getTime();
		assertTrue(elapsedTime < 50);
	}

	@Test
	public void longTestsAreNotUnitTests() {
		Date startTime = new Date();
		for (long i = 0; i < 10000; i++) {
			for (long j = 0; j < 1000; j++) {
				String message = "When i=" + i + " and j=" + j + "the multiplication is less than 0";
				assertFalse(message, j * i < 0);
			}
		}
		Date endTime = new Date();
		long elapsedTime = endTime.getTime() - startTime.getTime();
		assertFalse(elapsedTime < 250);
	}

	/////////////////// ISOLATED/INDEPENDENT //////////////////////
	@Test
	public void testsWhereBrokenBehaviourIsNotClearAreBad() {
		Calculator calculator = new Calculator();
		calculator.add(5);
		calculator.subtract(3);
		calculator.multiplyBy(12);
		calculator.add(10);
		calculator.divideBy(2);
		assertEquals("I have no idea what broke", 17, calculator.getValue());
	}

	@Test
	public void testShouldIsolateTheBehaviourThatBroke() {
		Calculator calculator = new Calculator();
		assertEquals("Initial value of calculator should be 0", 0, calculator.getValue());
	}

	@Test
	public void theSystemUnderTestShouldBeASingleClass() {

	}

	@Test
	public void runningTestsInDifferentOrderShouldStillWork() {

	}

	/////////////////// REPEATABLE //////////////////////
	@Test
	public void testsShouldHaveTheSameResultIndependentlyOfExternalContext() {

	}

	@Test
	public void testsShouldNotHaveSideEffects() {

	}

	@Test
	public void testsShouldNotDependOnExternalServices() {
		// Example with date
	}

	/////////////////// SELF-VALIDATING //////////////////////
	@Test
	public void testsShouldBeSelfValidating() {

	}

	@Test
	public void testsShouldNotUsePrintoutsOrLogThings() {

	}

	/////////////////// TIMELY //////////////////////
	@Test
	public void testsShouldBeWritenBeforeTheCode() {
		ClassToBeDeveloped sut = new ClassToBeDeveloped();
		assertTrue(sut.unimplementedMethod());
	}
}
