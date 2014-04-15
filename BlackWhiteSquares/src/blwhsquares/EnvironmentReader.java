package blwhsquares;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import blwhsquares.Environment.Square;
import es.deusto.ingenieria.is.search.formulation.State;
import es.deusto.ingenieria.is.search.xml.StateXMLReader;

public class EnvironmentReader extends StateXMLReader {

	// The initial state environment state
	private State environment;
	private int length;

	// The initial problem environment state
	public EnvironmentReader(String fileXML) {
		super(fileXML);

	}

	public State getState() {
		return environment;
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public void startElement(String arg0, String arg1, String qname, Attributes attrs) throws SAXException {
		if(qname.equals("is:lineofsquares"))
		{
			this.length = Integer.parseInt(attrs.getValue("length"));
			this.environment= new Environment(this.length);
			for (int i = 1; i < this.length; i++)
				((Environment) this.environment).addSquare(Square.UNKNOWN);
		}
		else if(qname.equals("is:white"))
			((Environment) this.environment).setSquare(Square.WHITE);
		else if(qname.equals("is:black"))
			((Environment) this.environment).setSquare(Square.BLACK);
	}
}