package actions;

import blwhsquares.Environment;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public abstract class MoveRight extends Operator {

	// Number of squares to move right
	private int squaresToMove;
	
	public MoveRight(int squaresToMove) {
		this.squaresToMove= squaresToMove;
	}
	
	// This method depends on the current state color generally.
	// To be defined by sons.
	public abstract boolean isApplicable(State st);

	// The effect is inherited and is always the same (depending on 'squaresToMove')
	public State effect(State arg0) {
		// The effect is to move X squares right if the action is applicable.
		if(isApplicable(arg0))
			((Environment) arg0).setCurrentPos(((Environment) arg0).getCurrentPos() + squaresToMove);
		return arg0;
	}

}
