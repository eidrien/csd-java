package org.agilar.csd.unitTesting;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleUnitTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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
	
	@Test
	public void comparingLists() {
		fail("Add tests on how to compare lists");
	}
	
	@Test(expected = RuntimeException.class)
	public void testException(){
		throw new RuntimeException();
	}
	
	@Test
	public void testExceptionOldSchool(){
		try{
			throw new RuntimeException("Some exception mate!");
		}catch(RuntimeException e){
			assertTrue(e.getMessage().contains("exception"));
		}
		
	}
	
	public void beCarefulOfTestsThatDontRun(){
		fail("Why isn't this failing?");
	}
	
}
