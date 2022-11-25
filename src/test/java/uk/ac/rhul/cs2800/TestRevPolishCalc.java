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
		assertEquals(revPolishCalc.isOperator("G"), false, "The isOperator method should return false with input G");
	}
	
	@Test
	void testIsNumeric() {
		assertEquals(revPolishCalc.isNumeric("12"), true, "The isNumeric method should return true with input 12");
		assertEquals(revPolishCalc.isNumeric("bbb"), false, "The isNumeric method should return false with input bbb");

	}

}
