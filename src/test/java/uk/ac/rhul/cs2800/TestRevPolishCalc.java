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
	void testOperators() throws Exception {
		assertEquals(revPolishCalc.evaluate("+"), 0f, "The evaluate method should return 0f with input +");
		assertEquals(revPolishCalc.evaluate("-"), 1f, "The evaluate method should return 1f with input -");
		assertEquals(revPolishCalc.evaluate("*"), 2f, "The evaluate method should return 2f with input *");
		assertEquals(revPolishCalc.evaluate("/"), 3f, "The evaluate method should return 3f with input /");
	}
	
	@Test
	void testIllegalOperator() throws Exception {
		assertThrows(Exception.class, () -> revPolishCalc.evaluate("?"));
	}

}
