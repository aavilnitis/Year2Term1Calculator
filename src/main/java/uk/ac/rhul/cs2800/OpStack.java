package uk.ac.rhul.cs2800;

public class OpStack {
	private RhulStack opStack;
	
	public OpStack() {
		this.opStack = new RhulStack();
	}

	public boolean isEmpty() {
		return this.opStack.size == 0;
	}

	public int size() {
		return this.opStack.size;
	}

	public void push(Symbol s) {
		Entry entry = new Entry(s);
		opStack.push(entry);
	}
	
	
}

