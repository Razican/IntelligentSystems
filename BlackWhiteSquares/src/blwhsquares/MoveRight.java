package blwhsquares;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class MoveRight extends Operator {

	// Number of squares to move right
	private int squaresToMove;
	
	public MoveRight(int squaresToMove) {
		this.squaresToMove= squaresToMove;
	}
	
	public boolean isApplicable(State st) {
		// There aren't any conditions to fulfill in order to move 'x'
		// squares right
		return true;
	}

	protected State effect(State arg0) {
		// The effect is to move X squares right.
		((Environment) arg0).setCurrentPos(((Environment) arg0).getCurrentPos() + squaresToMove);
		return arg0;
	}

}
