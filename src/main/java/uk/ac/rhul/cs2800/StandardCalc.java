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
	
	public float evaluate(String what) throws Exception {
		scanner = new Scanner(what);
		while(scanner.hasNext()) {
			next = scanner.next();
			if (isNumeric(next)) {
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
		while (!opStack.isEmpty()) {
			if (opStack.top() != Symbol.LEFT_BRACKET) {
				postfix += opStack.pop().toString() + " ";
			} else {
				opStack.pop();
			}
		}
		
		return rpCalc.evaluate(postfix);
	}

	protected boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	protected boolean isOperator(String string) {
		if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
			return true;
		}
		return false;
	}

	protected boolean isLeftBracket(String string) {
		return string.equals("(");
	}

	protected boolean isRightBracket(String string) {
		return string.equals(")");
	}

	protected int precedence(String op) {
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

	protected Symbol whichSymbol(String symbol) {
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
