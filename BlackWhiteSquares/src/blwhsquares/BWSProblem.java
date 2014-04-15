package blwhsquares;

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

	private int length;
	private Scanner scan = new Scanner(System.in);

	public BWSProblem() {
		addInitialState(gatherInitialPercepts());
	}

	/** Constructor that specifies the percepts. 
	 * @param percepts - path to percepts
	 */
	public BWSProblem(String percepts) {
		addInitialState(gatherInitialPercepts(percepts));
	}

	@Override
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
		length = reader.getLength();
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
		// We search for the solution
		return alg.search(this, getInitialStates().get(0));
	}

	// HW 5
	@Override
	public boolean isFullyObserved(State state) { //TODO
		return ((Environment)state).getLine().size() == length;
	}

	@Override
	public State gatherPercepts(State state) {
		String read = "";
		State st = ((Environment)state).clone();
		
		// Repeat until correct
		do {
			System.out.println("\n$ Gathering perceps. ");
			System.out.print("$ Current square's colour? [BLACK|WHITE] >>");
			read = scan.nextLine();
		} while (read.equals("BLACK") && read.equals("WHITE\n"));
		
		((Environment) st).setSquare(Square.valueOf(read));

		return st;
	}
	
	public int getLength()
	{
		return length;
	}
}