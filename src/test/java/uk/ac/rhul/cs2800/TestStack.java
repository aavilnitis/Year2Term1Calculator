package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {
  RhulStack rs;
  Entry numberEntry;
  Entry symbolEntry;


  /**
   * Test1 - Creates three different Entries and tests if a stack can be initialised. To get this
   * test to pass I had to create a public constructor in RhulStack that initialises a new RhulStack
   * object. To later refactor and clean up code smells I added two Entry objects to the test and
   * the BeforeEach notation to use in the rest of the tests, as well as to make sure all the other
   * tests show correct results, a new RhulStack is initialised before each one.
   */
  @BeforeEach
  void setup() {
    numberEntry = new Entry((float) 5);
    symbolEntry = new Entry(Symbol.MINUS);
    rs = new RhulStack();
  }

  /**
   * Test2 - tests the size of the Stack right after creation. To get this test to pass i had to
   * create a size variable in RhulStack and set it to zero in the constructor.
   */
  @Test
  void testSize() {
    RhulStack rs = new RhulStack();
    assertEquals(rs.size, 0, "Test a newly created stack to see that it has size zero.");
  }

  /**
   * Test3 - Test if pushing to the stack increases it's size. To get this test to pass I had to
   * create a push() method that increases the size value by one.
   */
  @Test
  void testPush() {
    rs.push(new Entry((float) 5));
    assertEquals(rs.size, 1, "Test that push increases the size of an empty stack.");
  }

  /**
   * Test4 - Test if pop() throws an Exception if the size is zero. To get this test to pass I had
   * to create a pop() method that throws an exception if the size variable is zero.
   */
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> rs.pop(), "You cannot pop from an empty stack.");
  }

  /**
   * Test5 - Test if push() and then pop() returns the same Entry and if size updates along the way.
   * To get this test to pass I had to create an Array that stores Entries in the RhulStack class.
   * After that i had to update the push() method to actually push Entries on to the Array and only
   * then increase the size, as well as the pop() method now had to decrease the size and return an
   * Entry object from the (size-1) index in the Array, finally making RhulStack a functional Stack
   * class.
   */
  @Test
  void testPushThenPop() {
    rs.push(numberEntry);
    assertEquals(rs.pop(), numberEntry, "Pushing a five then popping it should return 5.");
    assertEquals(rs.size, 0, "Pushing a five then popping it should give an empty stack.");
    assertThrows(EmptyStackException.class, () -> rs.pop(),
        "Push, pop, pop should throw an exception.");
  }

  /**
   * Test6 - Test if pushing twice increases the size by two, if the Entries returned match with the
   * ones pushed, if the size after pushing and popping twice updates the size correctly and if
   * popping one last time throws an EmptyStackException This test passed on the first try because
   * of the refactoring and code changes made in the previous test.
   */
  @Test
  void testPushTwice() {
    rs.push(numberEntry);
    rs.push(symbolEntry);
    assertEquals(rs.size, 2, "Pushing twice should give size 2");
    assertEquals(rs.pop(), symbolEntry,
        "Pushing twice then popping should return the second thing pushed.");
    assertEquals(rs.pop(), numberEntry,
        "Pushing twice then popping should return the first thing pushed.");
    assertEquals(rs.size, 0, "Pushing twice then popping twice should give an empty stack.");
    assertThrows(EmptyStackException.class, () -> rs.pop(),
        "Push, pop, pop should throw an exception.");
  }

  /**
   * Test7 - Test if you can push lots and lots of entries on to the stack and if the size variable
   * updates correctly. To get this test to pass i had to increase the size of the Array to the
   * number of how many times I am pushing to the array. To then remove code smells created by
   * adding a large magic number to the RhulStack class I changed the Array to an ArrayList that
   * doesn't have a limit on its size.
   */
  @Test
  void testPushLots() {
    for (int index = 0; index < 1000; index++) {
      rs.push(numberEntry);
      rs.push(symbolEntry);
      assertEquals(rs.size, (index + 1) * 2, "Pushing should increse the size.");
    }
  }

  /**
   * Test8 - Test if you can get the top element of the Stack without removing it from the Stack. To
   * get this test to pass i had to create a top() method in RhulStack and make it return the Entry
   * stored in the (size-1) index of the ArrayList.
   */
  @Test
  void testTop() {
    rs.push(numberEntry);
    rs.push(symbolEntry);
    assertEquals(rs.top(), symbolEntry, "Top entry should be the one that was added last.");
  }

  /**
   * Test9 - Test if calling top() on an empty Stack throws an EmptyStackException. To get this test
   * to pass I had to create a conditional statement is top() that throws an EmptyStackException if
   * the size variable is zero.
   */
  @Test
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> rs.top(),
        "You cannot get the top element from an empty stack.");
  }



}
