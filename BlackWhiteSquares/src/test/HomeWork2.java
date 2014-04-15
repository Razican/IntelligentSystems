package test;

import java.util.List;

import blwhsquares.BWSProblem;
import blwhsquares.Environment;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class HomeWork2 {

	public static void main(String[] args) {
		BWSProblem p = new BWSProblem();

		List<State> states = p.getInitialStates();
		System.out.println(states.get(0));
		((BWSProblem) p).createOperators();

		
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
			System.out.println(o.apply(states.get(0)));
		}
	}
}