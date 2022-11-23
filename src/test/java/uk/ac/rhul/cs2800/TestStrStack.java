package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
	StrStack strStack;

	@BeforeEach
	void setup() {
		strStack = new StrStack();
	}
	
	@Test
	void testIsEmpty() {
		assertEquals(strStack.isEmpty(), true, "isEmpty() of newly created strStack should return true.");
	}
	
	@Test
	void testSize() {
		assertEquals(strStack.size(), 0, "Size of newly created strStack should be zero.");
	}

}
