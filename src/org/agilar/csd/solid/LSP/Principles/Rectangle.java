package org.agilar.csd.solid.LSP.Principles;

public class Rectangle {
	 
	  private int width;
	  private int height;
	 
	  
	  public  void AssignWidth(int width)
	  {
	    this.width = width;
	  }
	  
	  public  void AssignHeight(int height)
	  {
	    this.height = height;
	  }
	 
	  public int GetWidth()
	  {
	    return width;
	  }
	 
	  public int GetHeight()
	  {
	    return height;
	  }
	 
	  public int CalculateArea()
	  {
	    return width * height;
	  }
}
