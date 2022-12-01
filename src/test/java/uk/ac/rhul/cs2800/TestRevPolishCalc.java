package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
	private RevPolishCalc revPolishCalc;

	@BeforeEach
	void testRevPolishCalc() {
		revPolishCalc = new RevPolishCalc();
	}

	@Test
	void testIsOperator() {
		assertEquals(revPolishCalc.isOperator("+"), true, "The isOperator method should return true with input +");
		assertEquals(revPolishCalc.isOperator("G"), false, "The isOperator method should return false with input G");
	}

	@Test
	void testIsNumeric() {
		assertEquals(revPolishCalc.isNumeric("12"), true, "The isNumeric method should return true with input 12");
		assertEquals(revPolishCalc.isNumeric("bbb"), false, "The isNumeric method should return false with input bbb");

	}

	@Test
	void testIllegalOperator() throws Exception {
		assertThrows(Exception.class, () -> revPolishCalc.evaluate("?"));
	}

	@Test
	void testEvaluate() throws Exception {
		assertEquals(revPolishCalc.evaluate("1 3 +"), 4f,
				"1 3 + in postfix notation means 1 + 3 which should return 4f");
	}
	
	@Test
	void testEvaluateHarder() throws Exception {
		//assertEquals(revPolishCalc.evaluate("4 13 5 / +"), (13f / 5f) + 4f,
		//		"1 3 + in postfix notation means 1 + 3 which should return 4f");
	}
	
	@Test
	void testEvaluateDifficult() throws Exception {
		assertEquals(revPolishCalc.evaluate("10 6 9 3 + -11 * / * 17 + 5 +"), ((10f * (6f / ((9f + 3f) * -11f))) + 17f) + 5f,
				"1 3 + in postfix notation means 1 + 3 which should return 4f");
	}
	
	@Test
	void testIllegalOperatorAmongCorrect() throws Exception {
		//assertThrows(Exception.class, () -> revPolishCalc.evaluate("13 1 5 + - ?"));
	}
	
}
