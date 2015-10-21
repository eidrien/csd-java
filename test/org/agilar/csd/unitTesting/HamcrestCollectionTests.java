package org.agilar.csd.unitTesting;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HamcrestCollectionTests {

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
	public void testForSize() {
	    assertThat(someNumbers, hasSize(5));
	}

	@Test
	public void testWhetherListContainsItemsInSameOrder() {
	    assertThat(someNumbers, contains(1, 2, 3, 4, 5));
	}

	@Test
	public void testWhetherListContainsItemsInAnyOrder() {
		assertThat(someNumbers, containsInAnyOrder(5, 4, 3, 2, 1));
	}

	@Test
	public void testInvariantsInValuesInAList() {
	    assertThat(someNumbers, everyItem(lessThanOrEqualTo(5)));
	}

}
