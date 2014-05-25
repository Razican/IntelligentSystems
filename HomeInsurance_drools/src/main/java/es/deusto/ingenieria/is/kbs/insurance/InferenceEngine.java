package es.deusto.ingenieria.is.kbs.insurance;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import es.deusto.ingenieria.is.kbs.insurance.Home.ConstructionQuality;
import es.deusto.ingenieria.is.kbs.insurance.Home.Type;

public class InferenceEngine {

	public static void main(String[] args) {
		try {
			Home home = new Home();
			home.setAddress("20 Ingram St. Forest Hills, NY (Queens)");
			home.setOwner("Peter Parker");
			home.setAge(20);
			home.setBudget(300);
			home.setType(Type.HOUSE);
			home.setImprovements(true);
			home.setQuality(ConstructionQuality.EXCELLENT);
			home.setExpensiveBelongins(false);

			Home home2 = new Home();
			home2.setAddress("Metropolis, Illinois");
			home2.setOwner("Clark Kent");
			home2.setAge(6);
			home2.setBudget(200);
			home2.setType(Type.APARTMENT);
			home2.setImprovements(true);
			home2.setQuality(ConstructionQuality.AVERAGE);
			home2.setExpensiveBelongins(false);
			
			Home home3 = new Home();
			home3.setAddress("Wayne Manor - Bristol Hills, Gotham City");
			home3.setOwner("Bruce Wayne");
			home3.setAge(40);
			home3.setBudget(300);
			home3.setExpensiveBelongins(false);			

			//Before the inference process
			System.out.println("BEFORE THE INFERENCE PROCESS");
			System.out.println("------ --- --------- -------");
			System.out.println(home);
			System.out.println("\n" + home2);
			System.out.println("\n" + home3);

			// KieServices is the factory for all KIE services 
	        KieServices kService = KieServices.Factory.get();
	        
	        // From the KIE services, a container is created from the classpath
	        KieContainer kContainer = kService.getKieClasspathContainer();
	        
	        // From the container, a session is created based on  
	        // its definition and configuration in the META-INF/kmodule.xml file 
	        KieSession kSession = kContainer.newKieSession("insurance-session");
	        
	        // Setup a file based audit logger 
	        KieRuntimeLogger logger = kService.getLoggers().newFileLogger(kSession, "./log/insurance");
					
			// Insert facts in the KIE session
			kSession.insert(home);
			kSession.insert(home2);
			kSession.insert(home3);

			System.out.println("\nDURING THE INFERENCE PROCESS");
			System.out.println("------ --- --------- -------");			
			
			//Invoke the inference mechanism
			kSession.fireAllRules();			

			//Close the inference process log
			logger.close();

			//After inference process
			System.out.println("\nAFTER THE INFERENCE PROCESS");
			System.out.println("----- --- --------- -------");			
			System.out.println(home);
			System.out.println("\n" + home2);
			System.out.println("\n" + home3);			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("MainProgram: " + ex.getMessage());
		}
	}
}