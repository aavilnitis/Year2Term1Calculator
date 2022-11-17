package uk.ac.rhul.cs2800;

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
		Entry entry = numStack.pop();
		float f = entry.getValue();
		return f;
	}

}
