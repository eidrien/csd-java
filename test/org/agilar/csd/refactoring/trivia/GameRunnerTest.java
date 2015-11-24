package org.agilar.csd.refactoring.trivia;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.Random;

import org.junit.Test;

public class GameRunnerTest {

	@Test
	public void testWithRandom1(){
		CheckSumOutput checkSumOutput = new CheckSumOutput();
		System.setOut(new PrintStream(checkSumOutput));
		Random random = new Random(1);
		
		GameRunner.runGame(random);
		
		long checkSum = checkSumOutput.getCheckSum();
		assertEquals(237445, checkSum);
	}

	@Test
	public void testWithRandom101(){
		CheckSumOutput checkSumOutput = new CheckSumOutput();
		System.setOut(new PrintStream(checkSumOutput));
		Random random = new Random(101);
		
		GameRunner.runGame(random);
		
		long checkSum = checkSumOutput.getCheckSum();
		assertEquals(236707, checkSum);
	}

}
