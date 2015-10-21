package org.agilar.csd.unitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionUnitTests {

	List<Integer> someNumbers, sameNumbers, otherNumbers, sameNumbersInDifferentOrder, lessNumbers, moreNumbers;
	
	@Before
	public void setUp() throws Exception {
		someNumbers = new ArrayList<Integer>();
		someNumbers.add(1);
		someNumbers.add(2);
		someNumbers.add(3);
		someNumbers.add(4);
		someNumbers.add(5);		
		
		sameNumbers = new ArrayList<Integer>(someNumbers);
		
		otherNumbers = new ArrayList<Integer>();
		otherNumbers.add(1);
		otherNumbers.add(2);
		otherNumbers.add(4);
		otherNumbers.add(8);
		otherNumbers.add(16);
		
		sameNumbersInDifferentOrder = new ArrayList<Integer>();
		sameNumbersInDifferentOrder.add(1);
		sameNumbersInDifferentOrder.add(2);
		sameNumbersInDifferentOrder.add(5);		
		sameNumbersInDifferentOrder.add(3);
		sameNumbersInDifferentOrder.add(4);
		
		lessNumbers = new ArrayList<Integer>(someNumbers);
		lessNumbers.remove(4);
		
		moreNumbers = new ArrayList<Integer>(someNumbers);
		moreNumbers.add(6);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void comparingLists() {
		
		assertListEquals("Lists do not contain the same items in the same order", someNumbers, sameNumbers);
		assertListHasSameItems("Lists do not contain the same items", someNumbers, sameNumbers);
	}
	
	private void assertListHasSameItems(String message, List<Integer> l1, List<Integer> l2) {
		assertEquals(message +": Lists are not of the same size", l1.size(), l2.size());
		for(Integer i : l1){
			assertTrue(message + ": item in first list is not in second list", l2.contains(i));
		}
		for(Integer i : l2){
			assertTrue(message + ": item in second list is not in first list", l1.contains(i));
		}
	}

	private void assertListEquals(String message, List<Integer> l1, List<Integer> l2) {
		assertEquals(message +": Lists are not of the same size", l1.size(), l2.size());
		for(int i=0; i<l1.size(); i++){
			assertEquals(message +": Item in position " + i + "is different (" + l1.get(i) + " vs " + l2.get(i), l1.get(i), l2.get(i));
		}
	}
	
}
