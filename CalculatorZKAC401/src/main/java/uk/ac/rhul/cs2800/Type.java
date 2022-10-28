package uk.ac.rhul.cs2800;

/**
 * The enum class Type stores the different Types of values an Entry object can store.
 * 
 * @author aleksisvilnitis
 */
public enum Type {
  NUMBER("Number"), SYMBOL("Symbol"), STRING("String"), INVALID("Invalid");

  private String type;

  /**
   * Public constructor for class Type that creates and initialises a Type object.
   * 
   * @param s the String value of the Type initialised
   */
  private Type(String s) {
    this.type = s;
  }

  @Override
  public String toString() {
    return type;
  }
}
