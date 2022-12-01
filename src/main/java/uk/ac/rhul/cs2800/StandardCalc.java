package uk.ac.rhul.cs2800;

public class StandardCalc {
	protected OpStack opStack;
	protected RevPolishCalc rpCalc;
	
	public StandardCalc() {
		this.opStack = new OpStack();
		this.rpCalc = new RevPolishCalc();
	}
}
