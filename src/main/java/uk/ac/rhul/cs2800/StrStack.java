package uk.ac.rhul.cs2800;

public class StrStack {
	private RhulStack strStack;
	
	public StrStack() {
		this.strStack = new RhulStack();
	}

	public boolean isEmpty() {
		return strStack.size == 0;
	}

	public int size() {
		return strStack.size;
	}

	public void push(String string) {
		Entry entry = new Entry(string);
		strStack.push(entry);
	}

}
