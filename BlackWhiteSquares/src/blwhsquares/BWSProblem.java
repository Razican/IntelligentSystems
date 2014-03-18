package blwhsquares;

import actions.MoveRightFour;
import actions.MoveRightOne;
import actions.MoveRightTwo;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class BWSProblem extends Problem {

	public BWSProblem() {
		addInitialState(gatherInitialPercepts());
	}
	
	public State gatherInitialPercepts() {
		EnvironmentReader reader= new EnvironmentReader("percepts/blackwhitesquares1.xml");
		// The first state read is the initial state
		return reader.getState();
	}
	
	public boolean isFinalState(State state) {
		// If the current position is smaller than the line's number of states we are not in the final state.
		return ((Environment) state).getCurrentPos() < ((Environment) state).getLine().size() ? false : true;	
	}
	
	public void createOperators()
	{
		super.addOperator(new MoveRightOne());
		super.addOperator(new MoveRightTwo());
		super.addOperator(new MoveRightFour());
	}
	
	public Node solve(SearchAlgorithm alg)
	{
		// TODO
	}
}
