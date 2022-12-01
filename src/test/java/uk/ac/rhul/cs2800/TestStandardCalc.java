package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStandardCalc {

	@Test
	void testStandardCalc() {
		StandardCalc standardCalc = new StandardCalc();
		assertNotEquals(standardCalc.opStack, null, "OpStack of newly created StandardCalc should be initialised.");
		assertNotEquals(standardCalc.rpCalc, null, "RevPolishCalc of newly created StandardCalc should be initialised.");
	}

}
