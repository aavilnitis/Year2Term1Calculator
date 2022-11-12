package uk.ac.rhul.cs2800;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TestNumStack {

	@Test
	void testNumStack() {
		NumStack numStack = new NumStack();
		assertNotEquals(numStack.numStack, null, "The newly created NumStack should be initialised and not null.");
	}

}
