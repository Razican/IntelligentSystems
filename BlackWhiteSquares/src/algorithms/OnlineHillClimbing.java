package algorithms;

import java.util.List;

import blwhsquares.BWSProblem;
import blwhsquares.Environment;

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
			if ( ! problem.isFullyObserved(bestSuccessor.getState()))
			{
				bestSuccessor.setState(problem.gatherPercepts(bestSuccessor.getState()));
			}
			System.out.println(bestSuccessor);
			// IF fcurrentNode better than or equal to fbestSuccessor
			if(getEvaluationFunction().calculateH(currentNode) <= getEvaluationFunction().calculateH(bestSuccessor) || ((Environment) currentNode.getState()).getCurrentPos() >= ((BWSProblem) problem).getLength())
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
		Node bestSuccessor = null;
		double fbestSuccessor = 0;
		// FOR EACH of the CurrentNode's succcessors DO
		for(Operator operator : operators) {
			Node successor = new Node(operator.apply(currentNode.getState()));
			// Compute f(successor)
			double fsuccessor = successor.getState() != null ? getEvaluationFunction().calculateH(successor) : ((BWSProblem) problem).getLength();
			// If fsuccessor better than fbestsuccessor THEN
			if(bestSuccessor == null || fsuccessor < fbestSuccessor) {
				bestSuccessor = successor;
				fbestSuccessor = fsuccessor;
			}
		}
		return bestSuccessor;
	}
	
}
