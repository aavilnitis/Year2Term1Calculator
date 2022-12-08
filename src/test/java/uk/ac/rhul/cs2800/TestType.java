package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestType {
  static Type number, symbol, invalid;

  /**
   * Test1 - tests all the different Types. To get this test to pass I had to create a new Enum
   * class of Type and create all the necessary Types as enums.
   */
  @BeforeAll
  static void testType() {
    number = Type.NUMBER;
    symbol = Type.SYMBOL;
  }

  /**
   * Test2 - tests if the toString method returns the Type in the correct form (Capitalised not all
   * caps). To get this test to pass i had to create a constructor for the Type Enums that takes a
   * String as a variable and sets it as the type value. Then i had to create a custom toString
   * method that returns the String value of the Enum.
   */
  @Test
  void testToString() {
    assertEquals(number.toString(), "Number",
        "toString() of Type should return a capitalised String of the name of the Type");
  }
}
