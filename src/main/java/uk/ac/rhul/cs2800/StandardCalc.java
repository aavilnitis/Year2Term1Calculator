package uk.ac.rhul.cs2800;

public class StandardCalc {
	private OpStack opStack;
	private RevPolishCalc rpCalc;
	
	public StandardCalc() {
		this.opStack = new OpStack();
		this.rpCalc = new RevPolishCalc();
	}

	public boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean isOperator(String string) {
		return true;
	}
}
