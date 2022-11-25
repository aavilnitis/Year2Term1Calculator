package uk.ac.rhul.cs2800;

public class RevPolishCalc {
	private NumStack numStack;
	
	public RevPolishCalc() {
		this.numStack = new NumStack();
	}

	public boolean isOperator(String string) {
		if(string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
			return true;
		}
		return false;
	}

	public  boolean isNumeric(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

}
