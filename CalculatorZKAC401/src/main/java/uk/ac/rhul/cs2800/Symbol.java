package uk.ac.rhul.cs2800;

/**
 * Enum class that stores the different Symbols of Type Symbol.
 * 
 * @author aleksisvilnitis
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), 
  INVALID("_");

  private String symbol;

  /**
   * Public constructor for Symbol class that creates and initialises a new Symbol object.
   * 
   * @param s the value of the symbol stored in Symbol object
   */
  private Symbol(String s) {
    symbol = s;
  }

  @Override
  public String toString() {
    return this.name() + "(" + symbol + ")";
  }
}
