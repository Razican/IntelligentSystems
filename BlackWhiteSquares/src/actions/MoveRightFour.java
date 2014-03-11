package actions;

import blwhsquares.Environment;
import blwhsquares.Environment.Square;
import es.deusto.ingenieria.is.search.formulation.State;

public class MoveRightFour extends MoveRight{

	private static final int moves= 4;
	
	public MoveRightFour() {
		super(moves);
	}

	public boolean isApplicable(State st) {
		// Condition: current square is BLACK
		// 'getCurrentSquareColor' defined in environment to make things easier.
		return ((Environment) st).getCurrentSquareColor().equals(Square.BLACK) ? true : false;
	}
}
