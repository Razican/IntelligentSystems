package blwhsquares;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.is.search.formulation.State;

public class Environment extends State implements Cloneable {

	public enum Square {
		WHITE,
		BLACK;
	}

	private List<Square> line;
	private int currentPos;

	public Environment(List<Square> line, int currentPos){
		super();
		this.currentPos= currentPos;
		this.line= line;
	}

	public Environment(int length){
		this.currentPos= 0;
		this.line= new ArrayList<Square>(length);
	}

	public void addSquare(Square sq){
		this.line.add(sq);
	}

	public List<Square> getLine() {
		return line;
	}

	public void setLine(List<Square> line) {
		this.line = line;
	}

	public int getCurrentPos() {
		return currentPos;
	}
	
	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}
	
	// Defined to make things easier
	public Square getCurrentSquareColor(){
		return line.get(currentPos);
	}

	public boolean equals(Object obj){
		// We first check if we have a correct object to compare
		if (obj == null || ! (obj instanceof Environment))
			return false;
		
		// When do we consider that two different environments are equal?
		// When both environments have the same number of squares + each square at position 'x' has the same colour
		if(((Environment) obj).getLine().size() != this.getLine().size())
			return false;
		
		boolean eq= true;
		int i= 0;
		
		while(eq && i < this.getLine().size()){
			if(this.getLine().get(i).equals(((Environment) obj).getLine().get(i)))
				i++;
			else eq= false;
		}
		return eq;
	}
	
	@Override
	public Environment clone()
	{
		//The list will not change, so we keep the reference to the current object and
		//we save space
		return new Environment(this.line, this.currentPos);
	}

	public String toString(){
		return "Environment currentPos: " + this.currentPos + "\n\t" + line;
	}
}
