package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEntry {
  Entry number;
  Entry symbol;
  Entry string;

  /**
   * Test1 - Tests if all three Entry types can be initialised. At first the test only included one
   * type of Entry - Number (constructor of type float). To get this test to pass I had to create a
   * public constructor in Entry that uses a float value. This was followed by two more testEntry
   * tests that creates and tests Entries of type String and Symbol. To pass those tests I created
   * two more constructors in the Entry class that take different values as params. To remove code
   * smells I then moved three seperate tests for different types to one single test that tests all
   * three at once before each of the other tests.
   */
  @BeforeEach
  void testEntry() {
    number = new Entry((float) 10.0f);
    symbol = new Entry(Symbol.MINUS);
    string = new Entry("String entry");
  }

  /**
   * Test2 - Tests if getType() returns the correct Type for a Number Entry. To get this test to
   * pass I had to create a method in class Entry that returns the Type Number.
   */
  @Test
  void testGetTypeNumber() {
    assertEquals(number.getType(), Type.NUMBER, "The Type returned should be equal Type.NUMBER");
  }

  /**
   * Test4 - Tests if getType() returns the correct Type for a Symbol Entry. To get this test to
   * pass I had to fix my previous cheating of a test by creating a Type variable in Entry that
   * stores the type of the Entry when it's initialised and return that instead.
   */
  @Test
  void testGetTypeSymbol() {
    assertEquals(symbol.getType(), Type.SYMBOL, "The Type returned should be equal Type.SYMBOL");
  }

  /**
   * Test5 - Tests if getType() returns the correct Type for a String Entry. The test passed as I
   * had fixed the getType method in the previous test.
   */
  @Test
  void testGetTypeString() {
    assertEquals(string.getType(), Type.STRING, "The Type returned should be equal Type.STRING");
  }

  /**
   * Test3 - Tests if getValue() returns the stored Value for a number Entry. At first this test
   * didn't include a throws decleration as there were not String or Symbol Entries making the only
   * type possible to use getValue() on - Number, which would be correct. To get this test to pass 
   * I had to create a getValue() method in Entry that returns (float) 10.00. To later fix errors 
   * and make the code functional without cheating the test I returned the value stored in Entry by
   * first checking if the Type of entry is Number and then returning the stored number. This
   * resulted in adding a throws IllegalArgumentException decleration, that changed to a
   * BadTypeException before Test8 where I had to create it.
   */
  @Test
  void testGetValue() throws BadTypeException {
    assertEquals(number.getValue(), 10.0f, 0.0001f,
        "The Number returned should match the one used in the constructor.");
  }

  /**
   * Test6 - Tests if getSymbol() returns the Symbol stored in Entry of type Symbol. To get this
   * test to pass i had to create a getSymbol() method in the Entry class and return Symbol.MINUS,
   * but later on to refactor and make the test work without cheating them by first checking if the
   * Type of entry is Symbol and then returning the stored Symbol. This resulted in adding a throws
   * IllegalArgumentException decleration, that changed to a BadTypeException before Test8 where I
   * had to create it.
   */
  @Test
  void testGetSymbol() throws BadTypeException {
    assertEquals(symbol.getSymbol(), Symbol.MINUS,
        "The Symbol returned should match the one used in the constructor.");
  }

  /**
   * Test7 - Tests if getString() returns the Symbol stored in Entry of type Symbol. To get this
   * test to pass i had to create a getString() method in the Entry class and return "String entry"
   * but later on to refactor and make the test work without cheating them by first checking if the
   * Type of entry is String and then returning the stored String. This resulted in adding a throws
   * IllegalArgumentException decleration, that changed to a BadTypeException before Test8 where I
   * had to create it.
   */
  @Test
  void testGetString() throws BadTypeException {
    assertEquals(string.getString(), "String entry",
        "The String returned should match the one used in the constructor.");
  }

  /**
   * Test8 - Tests if getValue() throws a BadTypeException if I try calling getValue() from a non
   * Number Entry. To get this test to pass I first had to create a BadTypeException and throw it 
   * in the getValue() method if Entry.type is not Number.
   */
  @Test
  void testGetNumberException() throws BadTypeException {
    BadTypeException e = assertThrows(BadTypeException.class, () -> string.getValue());
    assertEquals(e.getMessage(),
        "To use the function getValue(), The Entry has to be of type NUMBER.");
  }

  /**
   * Test9 - Tests if getSymbol() throws a BadTypeException if I try calling getSymbol() from a non
   * Symbol Entry. To get this test to pass I had to throw a BadTypeException in the getSymbol()
   * method if the Entry.type is not Symbol.
   * 
   */
  @Test
  void testGetSymbolException() {
    BadTypeException e = assertThrows(BadTypeException.class, () -> number.getSymbol());
    assertEquals(e.getMessage(),
        "To use the function getSymbol(), The Entry has to be of type SYMBOL.");
  }

  /**
   * Test10 - Tests if getString() throws a BadTypeException if I try calling getString() from a 
   * non String Entry. To get this test to pass I had to throw a BadTypeException in the 
   * getString() method if the Entry.type is not String.
   */
  @Test
  void testGetStringException() {
    BadTypeException e = assertThrows(BadTypeException.class, () -> symbol.getString());
    assertEquals(e.getMessage(),
        "To use the function getString(), The Entry has to be of type STRING.");
  }


  /**
   * Test11 - Tests if Entry.equals() returns true if two Entry objects have the same Type, value.
   * Before doing anything in Entry.java i checked if the test passes without any changes to
   * Entry.java by creating two Entry objects with the same type and value, but the equals() method
   * returned false. To get this test to pass i had to import a hashCode() method in Entry and then
   * import the equals() method that uses hashCode() to check if the two Entries are equal.
   */
  @Test
  void testEqualsNumber() {
    Entry entryOne = new Entry((float) 5.00);
    Entry entryTwo = new Entry((float) 5.00);
    assertEquals(entryOne.equals(entryTwo), true);
  }

}
