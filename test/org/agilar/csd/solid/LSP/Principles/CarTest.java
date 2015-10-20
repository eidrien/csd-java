package org.agilar.csd.solid.LSP.Principles;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import junit.framework.AssertionFailedError;

public class CarTest {

	@Test
	public void makeSureCarCanStart() {
		
		// var car = new Car(Color.Red);
		// var car = new BrokenCar(Color.Red); // Postconditions weakened
		Car car = new CrimeBossCar(Color.black, true); // Throws new type of
														// exceptions

		car.StartEngine();

		assertTrue(car.isEngineRunning());
	}

	@Test
	public void Make_sure_engine_is_running_after_start() {
		// var car = new Car(Color.Red);
		// var car = new Prius(Color.Red); // Changing invariants
		Car car = new StolenCar(Color.red); // Changing preconditions

		car.StartEngine();

		assertTrue(car.isEngineRunning());
	}

	@Test
	public void Make_sure_car_is_painted_correctly() {
		// var car = new Car(Color.Red);
	    PimpedCar car = new PimpedCar(Color.red); // Violating history constraint
		car.setTemperature(10);
		assertEquals(Color.red, car.getColor());
	}

}
