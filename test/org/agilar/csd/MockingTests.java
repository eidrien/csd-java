package org.agilar.csd;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MockingTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMockListInterface() {
		// mock creation
		List<String> mockedList = mock(List.class);

		// using mock object - it does not throw any "unexpected interaction" exception
		mockedList.add("one");
		mockedList.clear();

		// selective, explicit, highly readable verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
	
	@Test
	public void testMockListClass(){
	
		// you can mock concrete classes, not only interfaces
		LinkedList<String> mockedList = mock(LinkedList.class);
	
		// stubbing appears before the actual execution
		when(mockedList.get(0)).thenReturn("first");
	
		// the following prints "first"
		assertEquals("first", mockedList.get(0));
	
		// the following prints "null" because get(999) was not stubbed
		assertNull(mockedList.get(999));

	}

}
