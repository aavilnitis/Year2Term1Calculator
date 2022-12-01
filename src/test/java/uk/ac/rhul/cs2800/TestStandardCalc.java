package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

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
		assertEquals(standardCalc.isNumeric("?"), false, "isNumeric() should return false with input ?.");

	}

	@Test
	void testIsOperator() {
		assertEquals(standardCalc.isOperator("*"), true, "isOperator() should return true with input *.");
		assertEquals(standardCalc.isOperator("?"), false, "isOperator() should return false with input ?.");

	}
	
	@Test
	void testIsBracket() {
		assertEquals(standardCalc.isLeftBracket("("), true, "isLeftbracket() should return true with input (.");
		assertEquals(standardCalc.isLeftBracket("("), true, "isRightbracket() should return true with input ).");
	}
	
	@Test
	void testIsNotBracket() {
		assertEquals(standardCalc.isLeftBracket("?"), false, "isLeftbracket() should return true with input ?.");
		assertEquals(standardCalc.isLeftBracket("?"), false, "isRightbracket() should return true with input ?.");
	}
	
	@Test
	void testPrecedence() {
		assertEquals(standardCalc.precedence("+"), 0, "precedence() should return 0 with input +.");
		assertEquals(standardCalc.precedence("-"), 0, "precedence() should return 0 with input -.");
		assertEquals(standardCalc.precedence("*"), 1, "precedence() should return 1 with input *.");
		assertEquals(standardCalc.precedence("/"), 1, "precedence() should return 1 with input /.");
		assertThrows(IllegalArgumentException.class, () -> standardCalc.precedence("?"), 
				"precedence() method of StandardCalc should throw an IllegalArgumentException "
				+ "if the input is not an operator.");
	}
	
	@Test
	void testEvaluateScanner() {
		assertEquals(standardCalc.evaluate("test"), "test", "As I am currently testing if the scanner works, "
				+ "evaluate should return a String with the same input as given.");
		
	}

}
