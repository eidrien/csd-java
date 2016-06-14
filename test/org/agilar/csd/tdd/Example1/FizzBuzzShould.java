package org.agilar.csd.tdd.Example1;

import static  org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzShould
{

    private static final String Fizz = "Fizz";
    private static final String Buzz = "Buzz";
    private static final String FizzBuzz = "FizzBuzz";
    private static final String NotFizzBuzz = "NotFizzBuzz";
    private static final String WoooW = "WoooW";

    private FizzBuzz SUT;

    @Before
    public void SetUp (){
        SUT =  new FizzBuzz();
    }

    @After
    public void tearDown(){
        SUT = null;
    }

    @Test
    public void whenInputIsMultipleOf3ThenReturnFizz(){
        int param = 12;
        String resultOfTest = SUT.Execute(param);
        assertEquals(resultOfTest, Fizz );
    }

    @Test
    public void whenInputIsMultipleOf5ThenReturnBuzz(){
        int param =25;
        String resultOfTest = SUT.Execute(param);
        assertEquals(resultOfTest, Buzz );
    }

    @Test
    public void whenInputIsMultipleOf3And5ThenReturnFizzBuzz(){
        int param = 30;
        String resultOfTest = SUT.Execute(param);
        assertEquals(resultOfTest, FizzBuzz );
    }

    @Test
    public void whenInputIsNotMultipleOf5And3ThenReturnItSelveAsString(){
        int param = 19;
        String resultOfTest = SUT.Execute(param);
        assertEquals(resultOfTest, Integer.toString(param));
    }
    
    @Test
    public void whenInputIsMultpleOf5And3AndNotMultipleOf2ReturnsNotFizzBuzz(){
    	int param = 15;
    	String resultOfTest = SUT.Execute(param);
    	assertEquals(resultOfTest, NotFizzBuzz);
    }
    
    @Test
    public void whenInputIsMultpleOf5And3AndNotMultipleOf2ButMultipleOf7ReturnsWoooW(){
    	int param = 105;
    	int param2 = 140;
    	String resultOfTest = SUT.Execute(param);
    	assertEquals(resultOfTest, WoooW);
    	String resultOfTest2 = SUT.Execute(param);
    	assertEquals(resultOfTest2, Integer.toString(param2));
    	
    }
    
    
}
