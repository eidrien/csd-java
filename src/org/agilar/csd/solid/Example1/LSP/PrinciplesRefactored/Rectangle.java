package org.agilar.csd.solid.Example1.LSP.PrinciplesRefactored;

public class Rectangle extends Square {

	  private int width;
	  private int height;
	  
	
	
	  public  void AssignWidth(int width)
	  {
	     this.width = width;
	  }
	  
	 
	  public  void AsignarAlto(int height)
	  { 
		  this.height = height;
	  }
}
