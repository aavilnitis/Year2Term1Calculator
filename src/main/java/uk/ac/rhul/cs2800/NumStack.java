package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Stack class for Float values with functionality to push, pop and view the top.
 * 
 * @author aleksisvilnitis
 */
public class NumStack {
  private RhulStack numStack;

  /**
   * Public constructor for Class NumStack.
   */
  public NumStack() {
    this.numStack = new RhulStack();
  }

  /**
   * Public method that checks if the stack is empty or not.
   * 
   * @return true if size of stack is zero
   */
  public boolean isEmpty() {
    return numStack.size == 0;
  }

  /**
   * Public method that checks the size of the stack.
   * 
   * @return the size of the stack.
   */
  public int size() {
    return numStack.size;
  }

  /**
   * Public method to push a new Symbol on to the stack.
   * 
   * @param f the Float that's going to be pushed to the stack
   */
  public void push(float f) {
    Entry entry = new Entry(f);
    numStack.push(entry);
  }

  /**
   * Public method to get the top Float of the stack.
   * 
   * @return the top Float stored in the stack
   */
  public float pop() throws BadTypeException {
    Entry entry = numStack.pop();
    float f = entry.getValue();
    return f;
  }

}
