package blwhsquares;

import java.util.List;

import actions.MoveRight;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class Main {

	public static void main(String[] args) {
		
		Problem p = new BWSProblem("percepts/blackwhitesquares1.xml");
		
		List<State> states = p.getInitialStates();
		System.out.println(states.get(0));
		
		Environment finalState = new Environment(2);
		finalState.addSquare(Environment.Square.BLACK);
		finalState.addSquare(Environment.Square.WHITE);
		finalState.setCurrentPos(3);
		
		System.out.println(p.isFinalState(states.get(0)));
		System.out.println(p.isFinalState(finalState));
		
		((BWSProblem) p).createOperators();
		
		List<Operator> op = p.getOperators();
		System.out.println(op);
		
		for (Operator o : op)
		{
			System.out.println(((MoveRight) o).isApplicable(states.get(0)));
			System.out.println(((MoveRight) o).effect(states.get(0)));
		}
	}
}
