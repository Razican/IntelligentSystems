package actions;

import blwhsquares.Environment;
import blwhsquares.Environment.Square;
import es.deusto.ingenieria.is.search.formulation.State;

public class MoveRightTwo extends MoveRight{

	private static final int moves= 2;
	
	public MoveRightTwo() {
		super("MoveTwo", moves);
	}

	public boolean isApplicable(State st) {
		// Condition: current square is WHITE
		// 'getCurrentSquareColor' defined in environment to make things easier.
		return ((Environment) st).getCurrentSquareColor().equals(Square.WHITE) ? true : false;
	}

}
