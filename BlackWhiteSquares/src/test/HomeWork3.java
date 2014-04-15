package test;

import java.util.ArrayList;
import java.util.List;

import blwhsquares.BWSProblem;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFSwithLog;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFSwithLog;

public class HomeWork3 {

	public static void main(String[] args) {
		BWSProblem p = new BWSProblem();
		
		System.out.println("\n-----");
		System.out.println("Blind");
		System.out.println("-----\n");

		System.out.println("$ Running: BFS-log");
		Node n = p.solve(BreadthFSwithLog.getInstance());
		System.out.println(n);

		System.out.println("$ Running: DFS-log");
		n= p.solve(DepthFSwithLog.getInstance());
		System.out.println(n);

		System.out.println("\n-----");
		System.out.println("Performance measure");
		System.out.println("-----\n");

		double bfsTotal = 0, dfsTotal = 0;
		int checks = 10000;

		System.out.println("Checks to be performed: "+checks+"\n");

		for (int i = 0; i < checks; i++)
		{
			System.out.println("\n$ Running check #" + (i+1));
			List<String> solutionMoves= new ArrayList<String>();

			// BFS performance check:
			long start = System.nanoTime();
			n= p.solve(BreadthFS.getInstance());
			long end = System.nanoTime();

			bfsTotal += end-start;

			System.out.println("BFS solution:");
			BreadthFS.getInstance().solutionPath(n, solutionMoves);
			System.out.println("\t" + solutionMoves);


			// DFS performance check:
			start = System.nanoTime();
			n= p.solve(DepthFS.getInstance());
			end = System.nanoTime();

			dfsTotal += end-start;

			System.out.println("DFS solution");
			solutionMoves= new ArrayList<String>();
			DepthFS.getInstance().solutionPath(n, solutionMoves);
			System.out.println("\t" + solutionMoves);
		}
		System.out.println("\n-----");
		System.out.println("Stats");
		System.out.println("-----\n");
		System.out.println("BFS: " + bfsTotal/(checks*1000) + " μs");
		System.out.println("DFS: " + dfsTotal/(checks*1000) + " μs");

		System.out.println("Comparison (BFS/DFS): " + bfsTotal/dfsTotal);
	}
}