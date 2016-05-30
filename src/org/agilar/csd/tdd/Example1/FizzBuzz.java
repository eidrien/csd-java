package org.agilar.csd.tdd.Example1;

/**
 * Created by juanbacarditbarrera on 24/5/16.
 */
public class FizzBuzz {

    private static final String Empty = "";

    public String Execute(int n){
        //TODO: implement using Tests
        if(n%3 == 0 && n%5 == 0) return "FizzBuzz";
        if(n%3 == 0) return "Fizz";
        if(n%5 == 0) return "Buzz";
        return Integer.toString(n);
    }
}
