package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Stack class with functionality to push, pop and view the top, implemented using TDD principles.
 * 
 * @author aleksisvilnitis
 */
public class RhulStack {
  int size;
  private List<Entry> entries;

  /**
   * Public constructor for Class RhulStack.
   */
  public RhulStack() {
    entries = new ArrayList<Entry>();
    size = 0;
  }

  /**
   * Public method to push a new Entry on to the stack and increase the size by one.
   * 
   * @param entry the Entry Object that's going to be pushed to the stack
   */
  public void push(Entry entry) {
    entries.add(entry);
    size++;
  }

  /**
   * Public method to get the top Entry of the stack and remove it from the stack.
   * 
   * @return the top Entry object stored in the stack and remove it from the stack
   */
  public Entry pop() throws EmptyStackException{
    if (size == 0) {
      throw new EmptyStackException();
    }
    size--;
    Entry entry = entries.get(size);
    entries.remove(size);
    return entry;
  }

  /**
   * Public method to get the top element of the stack but not remove it from the stack.
   * 
   * @return the top Entry object stored in the stack without removing it
   */
  public Entry top() throws EmptyStackException{
    if (size == 0) {
      throw new EmptyStackException();
    }
    return entries.get(size - 1);
  }
}
