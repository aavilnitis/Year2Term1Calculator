package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	}
	
	@Test
	void testIsNotOperator() {
		assertEquals(revPolishCalc.isOperator("G"), false, "The isOperator method should return false with input G");
	}
	
	@Test
	void testIsNumeric() {
		assertEquals(revPolishCalc.isNumeric("12"), true, "The isNumeric method should return true with input 12");
	}
	
	@Test
	void testIsNotNumeric() {
		assertEquals(revPolishCalc.isNumeric("bbb"), false, "The isNumeric method should return false with input bbb");
	}
	
	//Evaluate testing: Returns 0f = operator, 1f = numeric, 3f = invalid.
	@Test
	void testEvaluateNumeric() {
		assertEquals(revPolishCalc.evaluate("1"), 1f, "The evaluate method should return 1f if I pass in a numeric value.");
	}
	
	@Test
	void testEvaluateOperator() {
		assertEquals(revPolishCalc.evaluate("+"), 0f, "The evaluate method should return 0f if I pass in an operator value.");
	}
	
	@Test
	void testEvaluateInvalid() {
		assertEquals(revPolishCalc.evaluate("."), 2f, "The evaluate method should return 2f if I pass in an invalid value.");
	}

}
