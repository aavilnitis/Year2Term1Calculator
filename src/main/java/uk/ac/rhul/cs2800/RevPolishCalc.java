package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class RevPolishCalc {
	private NumStack numStack;
	private String c;
	private float result, x, y;

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

	public float evaluate(String string) throws Exception {
		Scanner scanner = new Scanner(string);

		while (scanner.hasNext()) {
			c = scanner.next();

			if (isNumeric(c)) {
				numStack.push(Float.parseFloat(c));

			} else if (isOperator(c)) {
				switch(c) {
				case "+":
					x = numStack.pop();
					y = numStack.pop();
					numStack.push(x + y);
					break;
				case "-":
					x = numStack.pop();
					y = numStack.pop();
					numStack.push(y - x);
					break;
				case "*":
					x = numStack.pop();
					y = numStack.pop();
					numStack.push(x * y);
					break;
				case "/":
					x = numStack.pop();
					y = numStack.pop();
					numStack.push(y / x);
					break;
				default:
					break;
				}
			} else {
				throw new Exception("Illegal Operator!");
			}
		}
		return numStack.pop();
	}

}
