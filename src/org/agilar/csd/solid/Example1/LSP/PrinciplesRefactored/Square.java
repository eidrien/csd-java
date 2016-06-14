package org.agilar.csd.solid.Example1.LSP.PrinciplesRefactored;

public class Square {
	  private int lado;
	 
	
	  
	  public  void AsignarLado(int lado)
	  {
		  	this.lado = lado;
	  }
	  

	 
	  public int ObtenerLado()
	  {
	    return lado;
	  }
	 
	
	 
	  public int CalcularArea()
	  {
	    return lado * lado;
	  }
}
