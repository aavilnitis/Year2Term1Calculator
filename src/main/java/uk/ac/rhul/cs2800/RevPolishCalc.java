package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * RevPolishCalc class with functionality to evaluate postfix equations.
 * 
 * @author aleksisvilnitis
 */
public class RevPolishCalc {
  private NumStack numStack;
  private String next;
  private float operand1;
  private float operand2;

  /**
   * Public constructor for RevPolishCalc class.
   */
  public RevPolishCalc() {
    this.numStack = new NumStack();
  }
  
  /**
   * Public method to evaluate postfix equations from a string.
   * 
   * @param what postfix equation that's going to be calculated
   * @return float value of postfix equation result
   * @throws InvalidExpressionException when equation has illegal operator
   * @throws EmptyStackException when pop() is called, but size of stack is zero
   */
  public float evaluate(String what) throws Exception {
    Scanner scanner = new Scanner(what);

    while (scanner.hasNext()) {
      next = scanner.next();
      if (isOperator(next)) {
        operand2 = numStack.pop();
        operand1 = numStack.pop();
        switch (next) {
          case "+":
            numStack.push(operand1 + operand2);
            break;
          case "-":
            numStack.push(operand1 - operand2);
            break;
          case "*":
            numStack.push(operand1 * operand2);
            break;
          case "/":
            numStack.push(operand1 / operand2);
            break;
          default:
            break;
        }
      } else if (isNumeric(next)) {
        numStack.push(Float.parseFloat(next));
      } else {
        throw new InvalidExpressionException("Illegal Operator!");
      }
    }
    return numStack.pop();
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

  

}
