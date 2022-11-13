package uk.ac.rhul.cs2800;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {
	private NumStack numStack;

	@BeforeEach
	void setup() {
		numStack = new NumStack();
	}
	
	@Test
	void testIsEmpty() {
		assertEquals(numStack.isEmpty(), true, "isEmpty() of newly created numStack should return true.");
	}

}
