package test;

import algorithms.OnlineHillClimbing;
import blwhsquares.BWSProblem;
import es.deusto.ingenieria.is.search.algorithms.Node;
import eval.BWSEvalFun;

public class P2HomeWork1 {

	public static void main(String[] args) {
		BWSProblem p = new BWSProblem("percepts/blackwhitesquaresPartialpercepts1.xml");
		
		((BWSProblem) p).createOperators();
		
		BWSEvalFun evaluationFunction = new BWSEvalFun();
		Node n = p.solve(new OnlineHillClimbing(evaluationFunction));
		
		System.out.println(n.getState());
	}
}