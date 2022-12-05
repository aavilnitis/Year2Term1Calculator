package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Stack class for Symbols with functionality to push, pop and view the top.
 * 
 * @author aleksisvilnitis
 */
public class OpStack {
  private RhulStack opStack;

  /**
   * Public constructor for Class OpStack.
   */
  public OpStack() {
    this.opStack = new RhulStack();
  }

  /**
   * Public method that checks if the stack is empty or not.
   * 
   * @return true if size of stack is zero
   */
  public boolean isEmpty() {
    return this.opStack.size == 0;
  }

  /**
   * Public method that checks the size of the stack.
   * 
   * @return the size of the stack.
   */
  public int size() {
    return this.opStack.size;
  }

  /**
   * Public method that returns the top element of the stack without removing it.
   * 
   * @return top Symbol from opStack.
   * @throws EmptyStackException when the method is called, but size of array is zero.
   */
  public Symbol top() throws Exception {
    Entry entry = opStack.top();
    return entry.getSymbol();
  }

  /**
   * Public method to push a new Symbol on to the stack.
   * 
   * @param s the Symbol Object that's going to be pushed to the stack
   */
  public void push(Symbol s) {
    Entry entry = new Entry(s);
    opStack.push(entry);
  }

  /**
   * Public method to get the top Entry of the stack.
   * 
   * @return the top Symbol object stored in the stack
   */
  public Symbol pop() throws BadTypeException {
    Entry entry = opStack.pop();
    Symbol s = entry.getSymbol();
    return s;
  }


}

