package org.agilar.csd.solid.LSP.Principles;

import java.awt.Color;

public class BrokenCar extends Car {

	public BrokenCar(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}
	
	 @Override
	 public  void StartEngine()
     {
         throw new NotImplementedException();
     }

}
