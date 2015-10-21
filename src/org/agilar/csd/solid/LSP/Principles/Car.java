package org.agilar.csd.solid.LSP.Principles;

import java.awt.Color;

public class Car {
	private boolean _hasFuel = true;

    public Car(Color color)
    {
        this.color = color;
    }

    public void StartEngine()
    {
        if (!_hasFuel)
            throw new OutOfFuelException("Can't start a car without gas in tank...");

        engineRunning = true;
    }
    public  void StopEngine()
    {
        engineRunning = false;
    }

    private boolean engineRunning;

	public boolean isEngineRunning() {
		return engineRunning;
	}

	public void setEngineRunning(boolean isEngineRunning) {
		this.engineRunning = isEngineRunning;
	}
    
	private Color color;

	public Color getColor() {
		return color;
	}

	protected void setColor(Color color) {
		this.color = color;
	}
   
    
}
