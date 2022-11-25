package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TestRevPolishCalc {

	@Test
	void testRevPolishCalc() {
		RevPolishCalc revPolishCalc = new RevPolishCalc();
		assertNotEquals(revPolishCalc.numStack, null, "Newly created RevPolishCalc should have an initialised numStack variable.");
	}

}
