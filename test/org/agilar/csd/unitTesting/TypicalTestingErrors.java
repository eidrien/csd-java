package org.agilar.csd.unitTesting;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TypicalTestingErrors {

	@Test
	public void testContainingLogic_loops() {
		Calculator calculator = new Calculator();
		for(int i=0; i<5; i++){
			calculator.add(2);
		}
		Calculator secondCalculator = new Calculator();
		secondCalculator.add(2);
		secondCalculator.multiplyBy(5);
		assertEquals(calculator.getValue(), secondCalculator.getValue());
	}

	@Test
	public void testContainingLogic_ifs() {
		int number = (int)(Math.random()*20);
		Calculator calculator = new Calculator();
		calculator.add(number);
		calculator.divideBy(2);
		calculator.multiplyBy(2);
		if(number%2==0){ 
			assertEquals(number, calculator.getValue());
		}else{
			assertEquals(number, calculator.getValue()+1);
		}
	}

	@Test
	public void testContainingThingsThatChange_Random() {
		int number = (int)(Math.random()*Integer.MAX_VALUE);
		Calculator calculator = new Calculator();
		calculator.add(number);
		calculator.add(1);
		assertTrue(number < calculator.getValue());
	}

	@Test
	public void testContainingThingsThatChange_Date() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		assertNotEquals("No tests should be run on sabbath", dayOfWeek, 7);
	}

	@Test
	public void testProtectedOrPrivateMethods(){
		
	}
	
	@Test
	public void testsWithMultipleAssertsOnMultipleObjects(){
		Calculator calculator = new Calculator();
		assertEquals(0, calculator.getValue());
		calculator.add(5);
		assertEquals(5, calculator.getValue());
		calculator.add(1);
		assertEquals(6, calculator.getValue());
		calculator.divideBy(3);
		assertEquals(2, calculator.getValue());
		calculator.multiplyBy(5);
		assertEquals(10, calculator.getValue());
	}
	
	@Test
	public void lowTestCodeReadability() {
		Calculator c1 = new Calculator();
		Calculator c2 = new Calculator();
		assertEquals(0, c1.getValue());
		c1.add(5);
		assertEquals(0, c2.getValue());
		c2.add(4);
		assertEquals(5, c1.getValue());
		c1.add(1);
		assertEquals(4, c2.getValue());
		c2.add(2);
		assertEquals(6, c1.getValue());
		c1.divideBy(3);
		assertEquals(6, c2.getValue());
		c2.divideBy(2);
		assertEquals(2, c1.getValue());
		c1.multiplyBy(5);
		assertEquals(3, c2.getValue());
		c2.multiplyBy(5);
		assertEquals(10, c1.getValue());
		assertEquals(15, c2.getValue());
	}
	
	public void beCarefulOfTestsThatDontRun(){
		fail("Why isn't this failing?");
	}

}
