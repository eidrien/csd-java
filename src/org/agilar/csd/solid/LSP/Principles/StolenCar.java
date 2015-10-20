package org.agilar.csd.solid.LSP.Principles;

import java.awt.Color;

public class StolenCar extends Car {

	private boolean ignitionWiresStripped;

	public StolenCar(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	public void StripIgnitionWires() {
		ignitionWiresStripped = true;
	}

	@Override
	public void StartEngine() {
		if (!ignitionWiresStripped)
			return;
		super.StartEngine();
	}
}
