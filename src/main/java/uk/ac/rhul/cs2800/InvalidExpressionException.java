package uk.ac.rhul.cs2800;

/**
 * BadTypeException to throw when the user tries to get the wrong type of value in Entry.
 * 
 * @author aleksisvilnitis
 */
public class InvalidExpressionException extends Exception {

  /**
   * Public constructor for BadTypeException class.
   * 
   * @param message the error message displayed when an exception is thrown.
   */
  public InvalidExpressionException(String message) {
    super(message);
  }

}
