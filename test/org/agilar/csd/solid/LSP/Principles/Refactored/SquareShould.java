package org.agilar.csd.solid.LSP.Principles.Refactored;

import static org.junit.Assert.*;

import org.agilar.csd.solid.LSP.PrinciplesRefactored.Rectangle;
import org.agilar.csd.solid.LSP.PrinciplesRefactored.Square;
import org.junit.Test;

public class SquareShould {

	

	@Test
	public void CalculateAreaRectangle() {
		CalculateAreaSquareFormRefactored(new Rectangle());
	}

	@Test
	public void CalculateAreaSquareRefactored() {
		CalculateAreaSquareFormRefactored(new Square());
	}

	private void CalculateAreaSquareFormRefactored(Square square) {
		square.AsignarLado(10);
		assertEquals(20, square.CalcularArea());
	}

}
