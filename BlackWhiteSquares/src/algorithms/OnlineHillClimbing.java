package algorithms;

import java.util.List;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.algorithms.heuristic.HeuristicSearchMethod;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class OnlineHillClimbing extends HeuristicSearchMethod {

	public OnlineHillClimbing(EvaluationFunction function) {
		super(function);
	}

	public Node search(Problem problem, State initialState) {
		boolean localBestFound = false;
		// CurrentNode = InitialNode
		Node currentNode = new Node(initialState);
		// WHILE local_best NOT found DO
		while(!localBestFound) {
			// EXPAND currentNode's state and keep bestSuccessor
			Node bestSuccessor = expand(currentNode, problem);
			// IF fcurrentNode better than or equal to fbestSuccessor
			if(getEvaluationFunction().calculateH(currentNode) <= getEvaluationFunction().calculateH(bestSuccessor))
				// THEN local_best found
				localBestFound = true;
			else
				// currentNode = bestSuccessor
				currentNode = bestSuccessor;
		}
		return null;
	}
	
	protected Node expand(Node currentNode, Problem problem) { 
		List<Operator> operators = problem.getOperators();
		// bestSuccessor = currentNode's first succesor
		Node bestSuccessor = new Node(operators.get(0).apply(currentNode.getState()));
		// (needed later)
		double fbestSuccessor = getEvaluationFunction().calculateH(bestSuccessor);
		operators.remove(0);
		// FOR EACH of the rest of CurrentNode's succcessors DO
		for(Operator operator : operators) {
			Node successor = new Node(operator.apply(currentNode.getState()));
			// Compute f(successor)
			double fsuccessor = getEvaluationFunction().calculateH(successor);
			// If fsuccessor better than fbestsuccessor THEN
			if(fsuccessor < fbestSuccessor) {
				bestSuccessor = successor;
				fbestSuccessor = fsuccessor;
			}
		}
		return bestSuccessor;
	}
	
}
