package eval;

import blwhsquares.Environment;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;

public class BWSEvalFun extends EvaluationFunction{

	
	public double calculateG(Node node) {
		// The accumulated cost is the current position
		// since the cost from a node to the next one is always 1
		return ((Environment) node.getState()).getCurrentPos();
	}

	
	public double calculateH(Node node) {
		// Long names due to consistency according to what we wrote on the questions
		double numberOfSquaresToLastSquare = ((Environment) node.getState()).getLine().size() - ((Environment) node.getState()).getCurrentPos();
		return Math.floor(numberOfSquaresToLastSquare / 4d);
	}

}
