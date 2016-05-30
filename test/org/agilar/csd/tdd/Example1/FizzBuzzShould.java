package org.agilar.csd.tdd.Example1;

import static  org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by juanbacarditbarrera on 24/5/16.
 */
public class FizzBuzzShould
{

    private static final String Fizz = "Fizz";
    private static final String Buzz = "Buzz";
    private static final String FizzBuzz = "FizzBuzz";

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
    public void whenInputIsMultipleOfThreeReturnFizz(){
        int param = 12;
        String resultOfTest = SUT.Execute(param);
        assertEquals(resultOfTest, Fizz );
    }

    @Test
    public void whenInputIsMultipleOfFiveReturnBuzz(){
        int param =25;
        String resultOfTest = SUT.Execute(param);
        assertEquals(resultOfTest, Buzz );
    }

    @Test
    public void whenInputIsMultipleOfFiveAndThreeReturnFizzBuzz(){
        int param = 15;
        String resultOfTest = SUT.Execute(param);
        assertEquals(resultOfTest, FizzBuzz );
    }

    @Test
    public void whenInputIsNotMultipleOfFiveAndThreeReturnItSelvAsString(){
        int param = 19;
        String resultOfTest = SUT.Execute(param);
        assertEquals(resultOfTest, Integer.toString(param));
    }
}
