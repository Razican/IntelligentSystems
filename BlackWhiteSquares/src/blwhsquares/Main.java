package blwhsquares;

import es.deusto.ingenieria.is.search.formulation.State;

public class Main {

	public static void main(String[] args) {
		
		EnvironmentReader reader= new EnvironmentReader("percepts/blackwhitesquares1.xml");
		State x= reader.getState();
		System.out.println(x);
	}
}
