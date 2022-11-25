package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class RevPolishCalc {
	private NumStack numStack;
	private String c;
	private float result;

	public RevPolishCalc() {
		this.numStack = new NumStack();
	}

	public boolean isOperator(String string) {
		if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
			return true;
		}
		return false;
	}

	public boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public float evaluate(String string) {
		Scanner scanner = new Scanner(string);
		
		if(scanner.hasNext()) {
			c = scanner.next();
			if(isNumeric(c)) {
				return 1f;
			} else if(isOperator(c)) {
				return 0f;
			}
		}
		return 2f;
	}

}
