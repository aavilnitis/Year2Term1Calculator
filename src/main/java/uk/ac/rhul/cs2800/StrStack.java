package uk.ac.rhul.cs2800;

public class StrStack {
	private RhulStack strStack;
	
	public StrStack() {
		this.strStack = new RhulStack();
	}

	public boolean isEmpty() {
		return strStack.size == 0;
	}
}
