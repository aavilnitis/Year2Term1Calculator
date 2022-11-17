package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
	private OpStack opStack;

	@BeforeEach
	void setup() {
		opStack = new OpStack();
	}
	
	@Test
	void testIsEmpty() {
		assertEquals(opStack.isEmpty(), true, "isEmpty() of newly created opStack should return true.");
	}
	
	@Test
	void testSize() {
		assertEquals(opStack.size(), 0, "The size of newly created opStack should be zero.");
	}
	
	@Test
	void testPush() {
		opStack.push(Symbol.MINUS);
		assertEquals(opStack.size(), 1, "The size of opStack after pushing only once should be one.");
	}

}
