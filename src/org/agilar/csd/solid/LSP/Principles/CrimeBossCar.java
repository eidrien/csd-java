package org.agilar.csd.solid.LSP.Principles;

import java.awt.Color;

public class CrimeBossCar extends Car {

	private final boolean _boobyTrapped;

	public CrimeBossCar(Color color, boolean boobyTrap) {
		super(color);
		_boobyTrapped = boobyTrap;
	}

	@Override
	public void StartEngine() {
		if (_boobyTrapped)
			throw new MetYourMakerException("Boom! You are dead!");

		super.StartEngine();
	}

}
