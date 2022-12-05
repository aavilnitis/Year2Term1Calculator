package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * StandardCalc class with functionality to evaluate infix equations.
 * 
 * @author aleksisvilnitis
 */
public class StandardCalc {
  private OpStack opStack;
  private RevPolishCalc rpCalc;
  private Scanner scanner;
  private String next;
  private String postfix = "";

  /**
   * Public constructor for StandardCalc class.
   */
  public StandardCalc() {
    this.opStack = new OpStack();
    this.rpCalc = new RevPolishCalc();
  }

  /**
   * Public method to evaluate infix equations from a string.
   * 
   * @param what infix equation that's going to be calculated
   * @return float value of infix equation result
   * @throws Exception when equation has illegal operator
   * @throws EmptyStackException when pop() or top() is called, but size of stack is zero
   */
  public float evaluate(String what) throws Exception {
    scanner = new Scanner(what);
    while (scanner.hasNext()) {
      next = scanner.next();
      if (isNumeric(next)) {
        postfix += next + " ";
      } else if (isLeftBracket(next)) {
        opStack.push(whichSymbol(next));
      } else if (isRightBracket(next)) {
        while (opStack.top() != Symbol.LEFT_BRACKET) {
          postfix += opStack.pop().toString() + " ";
        }
        opStack.pop();
      } else if (isOperator(next)) {
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

  /**
   * Protected method that checks if a string contains a numeric value and only a numeric value.
   * 
   * @param str the String value that is checked
   * @return true if string contains only a numeric value
   */
  protected boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Protected method that checks if a string is equal to one of the allowed operators.
   * 
   * @param str the String value that is checked
   * @return true if string contains only an operator
   */
  protected boolean isOperator(String str) {
    if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
      return true;
    }
    return false;
  }

  /**
   * Protected method that checks if a string is equal to a left bracket.
   * 
   * @param str the String that is checked
   * @return true if str equals left bracket
   */
  protected boolean isLeftBracket(String str) {
    return str.equals("(");
  }

  /**
   * Protected method that checks if a string is equal to a right bracket.
   * 
   * @param str the String that is checked
   * @return true if str equals right bracket
   */
  protected boolean isRightBracket(String str) {
    return str.equals(")");
  }

  /**
   * Protected method that checks the precedence of given operator.
   * 
   * @param op the operator that is checked
   * @return level of precedence for given operator
   */
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

  /**
   * Protected method that checks what enum value of Symbol a String is equal to.
   * 
   * @param symbol the String value of the symbol checked
   * @return enum Symbol that is equal to String input
   */
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
