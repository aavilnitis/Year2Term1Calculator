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
	
	@Test
	void testPush() {
		strStack.push("String");
		assertEquals(strStack.size(), 1, "The size of strStack after pushing once should be one.");
	}
	
	@Test
	void testPop() throws BadTypeException {
		strStack.push("String");
		assertEquals(strStack.pop(), "String", "The string after pushing once and poping once should be the same.");
	}

}
