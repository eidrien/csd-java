package org.agilar.csd.solid.LSP.Principles;

public class Square extends Rectangle {

	  @Override
	  public  void AssignWidth(int widht)
	  {
	    super.AssignWidth(widht);
	    super.AssignHeight(widht);
	  }
	  
	  @Override
	  public  void AssignHeight(int height)
	  {
	    super.AssignHeight(height);
	    super.AssignWidth(height);
	  
	  }
}
