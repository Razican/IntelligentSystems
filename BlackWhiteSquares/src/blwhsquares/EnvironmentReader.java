package blwhsquares;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import blwhsquares.Environment.Square;
import es.deusto.ingenieria.is.search.formulation.State;
import es.deusto.ingenieria.is.search.xml.StateXMLReader;

public class EnvironmentReader extends StateXMLReader {

	// The initial state encironment state
	private State environment;
	
	// The initial problem environment state
	public EnvironmentReader(String fileXML) {
		super(fileXML);
		
	}

	public State getState() {
		return environment;
	}

	
	public void startElement(String arg0, String arg1, String qname, Attributes attrs) throws SAXException {
		if(qname.equals("is:lineofsquares"))
			this.environment= new Environment(Integer.parseInt(attrs.getValue("length")));
		else
			if(qname.equals("is:white"))
				((Environment) this.environment).addSquare(Square.WHITE);
			else
				if(qname.equals("is:black"))
					((Environment) this.environment).addSquare(Square.BLACK);
		
	}

}
