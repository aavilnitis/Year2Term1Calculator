package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class StandardCalc {
	private OpStack opStack;
	private RevPolishCalc rpCalc;
	private Scanner scanner;
	private String next, postfix = "";
	
	public StandardCalc() {
		this.opStack = new OpStack();
		this.rpCalc = new RevPolishCalc();
	}
	
	public String evaluate(String what) {
		scanner = new Scanner(what);
		while(scanner.hasNext()) {
			next = scanner.next();
			if (isNumeric(next)) {
				System.out.println(next);
				postfix += next + " ";
			}
			else if(isLeftBracket(next)) {
				postfix += "left_bracket ";
			}
			else if(isRightBracket(next)) {
				postfix += "right_bracket ";
			}
			else if (isOperator(next)) {
				postfix += "operator ";
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
