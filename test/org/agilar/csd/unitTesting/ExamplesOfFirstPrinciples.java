package org.agilar.csd.unitTesting;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ExamplesOfFirstPrinciples {

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

	static RegisterMachine machine = new RegisterMachine();
	
	@Test
	public void theSystemUnderTestShouldBeASingleClass() {
		//RegisterMachine uses Calculator, which is not being mocked
		machine.buy("Apple", 5);
		assertEquals(500, machine.getTotalAmount());
	}

	@Test
	public void runningTestsInDifferentOrderShouldStillWork() {
		machine.buy("Banana", 1);
		machine.buy("Strawberry", 1);
		assertEquals(150, machine.getTotalAmount());
	}

	/////////////////// REPEATABLE //////////////////////
	@Test
	public void testsShouldHaveTheSameResultIndependentlyOfExternalContext() {
		int number = (int)(Math.random()*Integer.MAX_VALUE);
		Calculator calculator = new Calculator();
		calculator.add(number);
		calculator.add(1);
		assertTrue(number < calculator.getValue());
	}

	@Test
	public void testsShouldNotHaveSideEffects() {
		int oldStartValue = Calculator.startValue;
		Calculator.startValue = 10;
		Calculator calculator = new Calculator();
		calculator.add(1);
		assertEquals(11, calculator.getValue());
		Calculator.startValue = oldStartValue;
	}

	@Test
	public void testsShouldNotDependOnExternalServices() {
		// Example with date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek == 7){
			fail("Tests shouldn't be run on sabbath");
		}else{
			assertTrue("Great time to run some tests", dayOfWeek != 7);
		}
	}

	/////////////////// SELF-VALIDATING //////////////////////
	@Test
	public void testsShouldBeSelfValidating() {
		int number = 5;
		Calculator calculator = new Calculator();
		calculator.add(number);
		calculator.add(1);
		System.out.println("Check " + number + " is smaller than " + calculator.getValue());
	}

	@Test
	public void testsShouldNotUsePrintoutsOrLogThings() {
		int number = (int)(Math.random()*Integer.MAX_VALUE);
		System.out.println(number);
		Calculator calculator = new Calculator();
		calculator.add(number);
		calculator.add(1);
		assertTrue(number < calculator.getValue());
	}

	/////////////////// TIMELY //////////////////////
	@Test
	public void testsShouldBeWritenBeforeTheCode() {
		ClassToBeDeveloped sut = new ClassToBeDeveloped();
		assertTrue(sut.unimplementedMethod());
	}
}
