package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

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
	
	public Symbol top() throws EmptyStackException, BadTypeException{
		Entry entry = opStack.top();
		return entry.getSymbol();
	}

	public void push(Symbol s) {
		Entry entry = new Entry(s);
		opStack.push(entry);
	}
	
	public Symbol pop() throws BadTypeException{
		Entry entry = opStack.pop();
		Symbol s = entry.getSymbol();
		return s;
	}
	
	
}

