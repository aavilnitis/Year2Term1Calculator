package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class StandardCalc {
	protected OpStack opStack;
	private RevPolishCalc rpCalc;
	private Scanner scanner;
	private String next, postfix = "";
	
	public StandardCalc() {
		this.opStack = new OpStack();
		this.rpCalc = new RevPolishCalc();
	}
	
	public String evaluate(String what) throws BadTypeException {
		scanner = new Scanner(what);
		while(scanner.hasNext()) {
			next = scanner.next();
			if (isNumeric(next)) {
				System.out.println(next);
				postfix += next + " ";
			}
			else if(isLeftBracket(next)) {
				opStack.push(whichSymbol(next));
			}
			else if(isRightBracket(next)) {
				while (opStack.top() != Symbol.LEFT_BRACKET) {
					postfix += opStack.pop().toString() + " ";
				}
				opStack.pop();
			}
			else if (isOperator(next)) {
				while (!opStack.isEmpty() && opStack.top() != Symbol.LEFT_BRACKET
						&& precedence(opStack.top().toString()) >= precedence(next)) {
					postfix += opStack.pop().toString() + " ";
				}
				opStack.push(whichSymbol(next));
			}
		}
		return postfix;
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
		if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
			return true;
		}
		return false;
	}

	public boolean isLeftBracket(String string) {
		return string.equals("(");
	}

	public boolean isRightBracket(String string) {
		return string.equals(")");
	}

	public int precedence(String op) {
		switch (op) {
		case "+":
		case "-":
			return 0;
		case "*":
		case "/":
			return 1;
		default:
			throw new IllegalArgumentException("Operator unknown: " + op);
		}
	}

	public Symbol whichSymbol(String symbol) {
		Symbol s;
		switch (symbol) {
		case "+":
			s = Symbol.PLUS;
			break;
		case "-":
			s = Symbol.MINUS;
			break;
		case "*":
			s = Symbol.TIMES;
			break;
		case "/":
			s = Symbol.DIVIDE;
			break;
		case "(":
			s = Symbol.LEFT_BRACKET;
			break;
		case ")":
			s = Symbol.RIGHT_BRACKET;
			break;
		default:
			s = Symbol.INVALID;
			break;
		}
		return s;
	}

	
}
