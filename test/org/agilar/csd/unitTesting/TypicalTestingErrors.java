package org.agilar.csd.unitTesting;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypicalTestingErrors {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContainingLogic() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testContainingThingsThatChange(){
		Random random;
		Date date;
	}

	@Test
	public void testProtectedOrPrivateMethods(){
		
	}
	
	@Test
	public void testsWithMultipleAssertsOnMultipleObjects(){
		
	}
	
	@Test
	public void lowTestCodeReadability() {
		
	}
}
