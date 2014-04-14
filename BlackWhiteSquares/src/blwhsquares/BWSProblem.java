package blwhsquares;

import java.util.List;
import java.util.Scanner;

import actions.MoveRightFour;
import actions.MoveRightOne;
import actions.MoveRightTwo;
import blwhsquares.Environment.Square;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class BWSProblem extends Problem {

	public BWSProblem() {
		addInitialState(gatherInitialPercepts());
	}

	/** Constructor that specifies the percepts. 
	 * @param percepts - path to percepts
	 */
	public BWSProblem(String percepts) {
		addInitialState(gatherInitialPercepts(percepts));
	}

	public State gatherInitialPercepts() {
		EnvironmentReader reader= new EnvironmentReader("percepts/blackwhitesquares1.xml");
		// The first state read is the initial state
		return reader.getState();
	}
	/** Gathers iniital percepts from the specified file
	 * @param percepts
	 * @return
	 */
	public State gatherInitialPercepts(String percepts) {
		EnvironmentReader reader= new EnvironmentReader(percepts);
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
		super.addOperator(new MoveRightTwo());
		super.addOperator(new MoveRightFour());
		super.addOperator(new MoveRightOne());

	}

	public Node solve(SearchMethod alg)
	{
		// We search for the solution
		return alg.search(this, getInitialStates().get(0));
	}

	// HW 5
	@Override
	public boolean isFullyObserved(State state) { //TODO
		return false;
	}

	@Override
	public State gatherPercepts(State state) { //TODO review, not sure about the environment thing
		Scanner scan = new Scanner(System.in);
		String read = "";
		// Repeat until correct
		do{
			System.out.println("\n$ Gathering perceps. ");
			System.out.print("$ Current square's colour? [BLACK|WHITE] >>");
			read = scan.nextLine();
		}while(read != "BLACK" && read != "WHITE");
		scan.close();
		List<Square> list = ((Environment)state).getLine();
		list.add(Square.valueOf(read));
		return new Environment(list, ((Environment)state).getCurrentPos());
	}


}