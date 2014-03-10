package blwhsquares;

public class Main {

	public static void main(String[] args) {
		
		EnvironmentReader reader= new EnvironmentReader("percepts/blackwhitesquares1.xml");
		System.out.println(reader.getState());
	}
}
