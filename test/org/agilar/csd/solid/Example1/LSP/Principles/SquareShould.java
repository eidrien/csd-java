package org.agilar.csd.solid.Example1.LSP.Principles;

import static org.junit.Assert.*;


import org.junit.Test;

public class SquareShould {

	@Test
	public void CalculateAreaRectangle() {
		CalculateAreaOfSquareForm(new Rectangle());
	}

	@Test
	public void CalculateAreaSquare() {
		CalculateAreaOfSquareForm(new Square());
	}

	private void CalculateAreaOfSquareForm(Rectangle rectangle) {
		rectangle.AssignHeight(10);
		rectangle.AssignWidth(2);
		assertEquals(20, rectangle.CalculateArea());
	}



}
