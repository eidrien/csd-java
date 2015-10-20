package org.agilar.csd.solid.LSP.Principles;

import java.awt.Color;

public class PimpedCar extends Car {

	private Color pimpedColor;
	
	public PimpedCar(Color color) {
		super(color);
		pimpedColor = color;
		// TODO Auto-generated constructor stub
	}
	
	public void setTemperature(int temp)
     {
         if (temp > 20)
             this.setColor(pimpedColor);
         else
             this.setColor(Color.black);
     }
	

}
