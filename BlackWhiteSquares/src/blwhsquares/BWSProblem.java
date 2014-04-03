package blwhsquares;

import java.util.ArrayList;
import java.util.List;

import actions.MoveRightFour;
import actions.MoveRightOne;
import actions.MoveRightTwo;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
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
	
	@Override
	public boolean isFinalState(State state) {
		// If the current position is smaller than the line's number of states we are not in the final state.
		return ((Environment) state).getCurrentPos() < ((Environment) state).getLine().size() ? false : true;	
	}
	
	public void createOperators()
	{
		// HW3 This arrangement gives the best timing for BFS
		//super.addOperator(new MoveRightFour());
		//super.addOperator(new MoveRightOne());
		//super.addOperator(new MoveRightTwo());
		super.addOperator(new MoveRightOne());
		super.addOperator(new MoveRightTwo());
		super.addOperator(new MoveRightFour());
	}
	
	public Node solve(SearchMethod alg)
	{
		// Feedback comment:
		// Better to call solutionPath() from solve() and please make sure
		// you save the sequence of actions found by your system in a log file
		// as we indicated in class: “createSolutionLog()” from SearchMethod.
		Node n = alg.search(this, getInitialStates().get(0));
		List<String> list = new ArrayList<String>();
		// TODO alg.solutionPath(n, list);
		// TODO alg.createSolutionLog(list);
		return n;
	}
}
