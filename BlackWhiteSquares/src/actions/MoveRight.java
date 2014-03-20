package actions;

import blwhsquares.Environment;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public abstract class MoveRight extends Operator {

	// Number of squares to move right
	private int squaresToMove;
	
	public MoveRight(String name, int squaresToMove) {
		super(name, 1);
		this.squaresToMove= squaresToMove;
	}
	
	// This method depends on the current state color generally.
	// To be defined by sons.
	protected abstract boolean isApplicable(State st);

	// The effect is inherited and is always the same (depending on 'squaresToMove')
	protected State effect(State arg0) {
		// We first clone the object
		Environment env = ((Environment) arg0).clone();
		
		// The effect is to move X squares right.
		env.setCurrentPos(env.getCurrentPos() + squaresToMove);
		
		return env;
	}
}