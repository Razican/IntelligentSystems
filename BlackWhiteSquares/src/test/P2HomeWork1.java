package test;

import java.util.ArrayList;
import java.util.List;

import algorithms.OnlineHillClimbing;
import blwhsquares.BWSProblem;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import eval.BWSEvalFun;

public class P2HomeWork1 {

	public static void main(String[] args) {
		BWSProblem p = new BWSProblem("percepts/blackwhitesquaresPartialpercepts1.xml");
		
		((BWSProblem) p).createOperators();
		
		BWSEvalFun evaluationFunction = new BWSEvalFun();
		SearchMethod alg = new OnlineHillClimbing(evaluationFunction);
		Node n = p.solve(alg);
		
		System.out.println(n);
		
		List<String> solutionMoves = new ArrayList<String>();
		alg.solutionPath(n, solutionMoves);
		
		System.out.println(solutionMoves);
		
		System.out.println();
		System.out.println();
		
		p = new BWSProblem();
		
		((BWSProblem) p).createOperators();
		
		n = p.solve(alg);
		
		System.out.println(n);
		
		solutionMoves = new ArrayList<String>();
		alg.solutionPath(n, solutionMoves);
		
		System.out.println(solutionMoves);
	}
}