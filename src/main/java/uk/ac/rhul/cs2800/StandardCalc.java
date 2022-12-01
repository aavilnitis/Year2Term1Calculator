package uk.ac.rhul.cs2800;

public class StandardCalc {
	private OpStack opStack;
	private RevPolishCalc rpCalc;
	
	public StandardCalc() {
		this.opStack = new OpStack();
		this.rpCalc = new RevPolishCalc();
	}
}
