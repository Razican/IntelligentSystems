package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.algorithms.heuristic.HeuristicSearchMethod;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class AStar extends HeuristicSearchMethod {

	public AStar(EvaluationFunction function) {
		super(function);
	}
	
	public Node search(Problem problem, State initialState) { 
		// Make a node with the initial problem state
		Node firstNode= new Node(initialState);
		// Insert node into the frontier data structure
		List<Node> frontier= new ArrayList<Node>();
		frontier.add(firstNode);
		// (Variables needed later on)
		List<Node> successorNodes= null;
		boolean solutionFound= false;
		// WHILE final state not found AND frontier is NOT empty DO
		while(!solutionFound && !frontier.isEmpty()){
			// Remove first node from the frontier
			firstNode= frontier.remove(0);
			// IF node contains final state
			if(problem.isFinalState(firstNode.getState()))
				// THEN final state found
				solutionFound= true;
			// IF node does not contain final state
			else
			{
				// EXPAND node's state
				successorNodes = expand(firstNode, problem);
				// Insert successor nodes into the frontier
				if(successorNodes != null && !successorNodes.isEmpty())
					frontier.addAll(successorNodes);
				// Sort frontier in ascending order of f(n)
				Collections.sort(frontier);
			}
		}
		// IF final state found THEN return sequence of actions found
		// ELSE return "solution not found"
		return solutionFound ? firstNode : null;
	}
	
	protected List<Node> expand(Node node, Problem problem) { 
		// Initialize Successors to an empty list
		List<Node> successorNodes= new ArrayList<Node>();
		// FOR EACH applicable action on state of current node DO
		for(Operator operator : problem.getOperators()){
			// Make a new successor node and generate succesor state
			State succesorState= operator.apply(node.getState());
			// (If the operator was applicable then a new state was generated and so succesorState != null)
			if(succesorState != null){
				// Successor node state = succesor state
				Node succesorNode= new Node(succesorState);
				// Successor node action = applicable action
				succesorNode.setOperator(operator.getName());
				// Successor node depth = current node depth + 1
				succesorNode.setDepth(node.getDepth() + 1);
				// We set it's parent
				succesorNode.setParent(node);
				// We set G
				succesorNode.setG(this.getEvaluationFunction().calculateG(succesorNode));
				// We set H
				succesorNode.setH(this.getEvaluationFunction().calculateH(succesorNode));
				// Add successor node to Successors
				successorNodes.add(succesorNode);
			}
		}
		// return Successors
		return successorNodes;
	}
}