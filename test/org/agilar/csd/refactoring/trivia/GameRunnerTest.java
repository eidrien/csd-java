package org.agilar.csd.refactoring.trivia;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameRunnerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testScaffold1() {
		CheckSumStreamOutput checksumCalculator = new CheckSumStreamOutput();
		System.setOut(new PrintStream(checksumCalculator));

		GameRunner.runGame(new Random(1));
		
		assertEquals(237445, checksumCalculator.getCheckSum());
	}

	@Test
	public void testScaffold1111() {
		CheckSumStreamOutput checksumCalculator = new CheckSumStreamOutput();
		System.setOut(new PrintStream(checksumCalculator));

		GameRunner.runGame(new Random(1111));
		
		assertEquals(397361, checksumCalculator.getCheckSum());
	}

}
