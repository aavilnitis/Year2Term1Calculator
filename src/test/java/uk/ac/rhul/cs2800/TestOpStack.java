package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TestOpStack {

	@Test
	void test() {
		OpStack opStack = new OpStack();
		assertNotEquals(opStack.opStack, null, "Newly created opStack should have an initialised RhulStack variable.");
	}

}
