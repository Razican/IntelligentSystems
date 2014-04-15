package test;

import java.util.ArrayList;
import java.util.List;

import blwhsquares.BWSProblem;

import algorithms.AStar;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;
import eval.BWSEvalFun;

public class HomeWork4 {

	public static void main(String[] args) {
		BWSProblem p = new BWSProblem();

		BWSEvalFun evaluationFunction = new BWSEvalFun();
		Node n = p.solve(new BestFS(evaluationFunction));
		List<String> solutionMoves = new ArrayList<String>();
		new BestFS(evaluationFunction).solutionPath(n, solutionMoves);
		System.out.println(solutionMoves);

		double brfsTotal = 0, dfsTotal = 0, bfsTotal = 0, astarTotal = 0;
		int checks = 10000;
		
		BWSEvalFun function = new BWSEvalFun();
		BreadthFS brfs = BreadthFS.getInstance();
		DepthFS dfs = DepthFS.getInstance();
		AStar aStar = new AStar(function);
		BestFS bfs = new BestFS(function);

		System.out.println("Checks to be performed: "+checks+"\n");

		for (int i = 0; i < checks; i++)
		{
			if( i % 1000 == 0)
				System.out.println("$ "+i+" checks run");

			// BreadthFS performance check:
			long start = System.nanoTime();
			p.solve(brfs);
			long end = System.nanoTime();

			brfsTotal += end-start;

			// DFS performance check:
			start = System.nanoTime();
			p.solve(dfs);
			end = System.nanoTime();

			dfsTotal += end-start;

			// Best FS performance check:
			start = System.nanoTime();
			p.solve(bfs);
			end = System.nanoTime();

			bfsTotal += end-start;
			
			// A* performance check:
			
			start = System.nanoTime();
			p.solve(aStar);
			end = System.nanoTime();
			
			astarTotal += end-start;
		}
		
		List<String> brfsSolution = new ArrayList<>();
		brfs.solutionPath(p.solve(brfs), brfsSolution);
		brfs.createSolutionLog(brfsSolution);
		
		List<String> dfsSolution = new ArrayList<>();
		dfs.solutionPath(p.solve(dfs), dfsSolution);
		dfs.createSolutionLog(dfsSolution);
		
		List<String> bfsSolution = new ArrayList<>();
		bfs.solutionPath(p.solve(brfs), bfsSolution);
		bfs.createSolutionLog(bfsSolution);
		
		List<String> astarSolution = new ArrayList<>();
		aStar.solutionPath(p.solve(aStar), astarSolution);
		aStar.createSolutionLog(astarSolution);
		
		System.out.println("\n-----");
		System.out.println("Stats");
		System.out.println("-----\n");
		System.out.println("BrFS: " + brfsTotal/(checks*1000) + " μs");
		System.out.println("DFS: " + dfsTotal/(checks*1000) + " μs");
		System.out.println("BFS: " + bfsTotal/(checks*1000) + " μs");
		System.out.println("A*: " + astarTotal/(checks*1000) + " μs");
		System.out.println();
		System.out.println("Comparison (BFS/DFS): " + bfsTotal/dfsTotal);
		System.out.println("Comparison (BFS/BrFS): " + bfsTotal/brfsTotal);
		System.out.println("Comparison (BFS/A*): " + bfsTotal/astarTotal);
		
		System.out.println("\n---------");
		System.out.println("Solutions");
		System.out.println("---------\n");
		System.out.println("BrFS: " + brfsSolution);
		System.out.println("DFS: "+ dfsSolution);
		System.out.println("BFS: "+bfsSolution);
		System.out.println("A*: " + astarSolution);
	}
}