package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TestStrStack {

	@Test
	void setup() {
		StrStack strStack = new StrStack();
		assertNotEquals(strStack.strStack, null, "Newly created strStack should contain RhulStack that has been initialised.");
	}

}
