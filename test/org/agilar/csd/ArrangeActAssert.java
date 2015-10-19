package org.agilar.csd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrangeActAssert {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//Arrange: The data used in a test should not depend on the environment in which the test is running. All the data needed for a test should be arranged as part of the test.
	//Act: Invoke the actual method under test.
	//Assert: A test method should test for a single logical outcome, implying that typically there
	@Test
	public void testsShouldHaveThreeSeparateParts() {
		fail("Not yet implemented");
	}

	@Test
	public void theArrangePartShouldNotHaveAsserts(){
		
	}
	
	@Test
	public void singleActionPerTest(){
		
	}
	
	@Test
	public void singleLogicalAssert(){
		
	}
}
