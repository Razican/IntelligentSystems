package actions;

import es.deusto.ingenieria.is.search.formulation.State;

public class MoveRightOne extends MoveRight{

	private static final int moves= 1;
	
	public MoveRightOne() {
		super("MoveOne", moves);
	}

	protected boolean isApplicable(State st) {
		// We can always move one square right
		return true;
	}

}
