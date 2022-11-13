package uk.ac.rhul.cs2800;

public class NumStack {
	protected RhulStack numStack;

	public NumStack() {
		this.numStack = new RhulStack();
	}

	public boolean isEmpty() {
		return numStack.size == 0;
	}

}
