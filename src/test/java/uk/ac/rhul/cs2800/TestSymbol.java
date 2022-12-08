package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestSymbol {
  static Symbol plus, minus, divide, times, left, right;

  /**
   * Test1 - tests all the different symbols. To get this test to pass I had to create a new Enum
   * class of Symbol and create all the necessary types of symbols as Enums.
   */
  @BeforeAll
  static void testSymbol() {
    plus = Symbol.PLUS;
    minus = Symbol.MINUS;
    divide = Symbol.DIVIDE;
    times = Symbol.TIMES;
    left = Symbol.LEFT_BRACKET;
    right = Symbol.RIGHT_BRACKET;
  }

  /**
   * Test2 - tests if the toString method returns the symbol not only the name of the enum. To get
   * this test to pass i had to create a cunstroctor for the Symbol Enums that takes a String as a
   * variable and sets it as the symbol. Then i had to create a custom toString method that returns
   * the name and the symbol of the Enum.
   */
  //@Test
  //void testToString() {
  //  assertEquals(plus.toString(), "PLUS(+)",
  //      "toString() of Symbol should return the name and the symbol");
  //}

}
