package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {
	StandardCalc standardCalc;

	@BeforeEach
	void setup() {
		standardCalc = new StandardCalc();
	}
	
	@Test
	void testIsNumeric() {
		assertEquals(standardCalc.isNumeric("5"), true, "isNumeric() should return true with input 5.");
	}
	
	@Test
	void testIsNotNumeric() {
		assertEquals(standardCalc.isNumeric("?"), false, "isNumeric() should return false with input ?.");
	}
	
	@Test
	void testIsOperator() {
		assertEquals(standardCalc.isOperator("*"), true, "isOperator() should return true with input *.");
	}
	
	@Test
	void testIsNotOperator() {
		assertEquals(standardCalc.isOperator("?"), false, "isOperator() should return false with input ?.");
	}
	

}
