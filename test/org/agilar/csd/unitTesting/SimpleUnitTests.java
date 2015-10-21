package org.agilar.csd.unitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleUnitTests {


	@Test
	public void passingTest() {
		assertTrue("It passes!", true);
	}
	
	@Test
	public void simpleAssertions() {

		Integer oneNumber = new Integer(5);
		Integer sameNumber = new Integer(5);
		Integer anotherNumber = new Integer(4);
		assertTrue("Show message when the condition is false", oneNumber.equals(sameNumber));
		assertFalse("Show message when the condition is true", oneNumber == anotherNumber);

		assertEquals("The two values are not the same", oneNumber, sameNumber);
		assertNotEquals("The two values are the same", oneNumber, anotherNumber);
		assertSame("The two objects are not the same", oneNumber, oneNumber);
		assertNotSame("The two objects are the same", oneNumber, sameNumber);
		
		assertNotNull("The value returned is null", oneNumber);
		assertNull("The value is not null", null);
	}
	
	@Test
	public void arrayAssertions() {
		
		int[] someNumbers = {1,2,3,4,5};
		int[] sameNumbers = {1,2,3,4,5};
		int[] otherNumbers = {5,4,3,2,1};
		assertArrayEquals("Numbers in the array are not the same", someNumbers, sameNumbers);
		assertArrayEquals("This should fail", someNumbers, otherNumbers);
	}

	@Test(expected = RuntimeException.class)
	public void testException(){
		methodThatThrowsException();
	}
	
	@Test
	public void testExceptionOldSchool(){
		try{
			methodThatThrowsException();
		}catch(RuntimeException e){
			assertTrue(e.getMessage().contains("exception"));
		}
		
	}

	private void methodThatThrowsException() {
		throw new RuntimeException("Some exception thrown!");
	}
		
}
