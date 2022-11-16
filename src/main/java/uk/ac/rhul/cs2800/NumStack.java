package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class NumStack {
	protected RhulStack numStack;

	public NumStack() {
		this.numStack = new RhulStack();
	}

	public boolean isEmpty() {
		return numStack.size == 0;
	}
	
	public int size() {
		return numStack.size;
	}

	public void push(float f) {
		Entry entry = new Entry(f);
		numStack.push(entry);
	}

	public float pop() throws BadTypeException{
		if(numStack.size > 0) {
			return numStack.pop().getValue();
		}else {
			throw new EmptyStackException();
		}
	}

}
