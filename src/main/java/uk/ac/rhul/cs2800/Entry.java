package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * Entry is a container class for either a Float, a String or a Symbol.
 *
 * @author aleksisvilnitis
 */
public class Entry {
  private float value;
  private Symbol symbol;
  private Type type;
  private String string;

  /**
   * Public constructor for Entry class that saves the value and sets Type to NUMBER.
   * 
   * @param v the value that's going to be stored in Entry.
   */
  public Entry(float v) {
    this.value = v;
    this.type = Type.NUMBER;
  }

  /**
   * Public constructor for Entry class that saves the symbol and sets Type to SYMBOL.
   * 
   * @param s the Symbol that's going to be stored in Entry.
   */
  public Entry(Symbol s) {
    this.symbol = s;
    this.type = Type.SYMBOL;
  }

  /**
   * Public constructor for Entry class that saves the String and sets Type to STRING.
   * 
   * @param st the String that's going to be stored in Entry.
   */
  public Entry(String st) {
    this.string = st;
    this.type = Type.STRING;
  }

  /**
   * Returns the float value stored if the type of Entry is NUMBER.
   * 
   * @return the value stored in Entry.
   * @throws BadTypeException if Type of entry is not NUMBER and getValue() is called
   */
  public float getValue() throws BadTypeException {
    if (this.type == Type.NUMBER) {
      return value;
    } else {
      throw new BadTypeException(
          "To use the function getValue(), The Entry has to be of type NUMBER.");
    }
  }

  /**
   * Returns the String value stored if the type of Entry is STRING.
   * 
   * @return the String stored in Entry.
   * @throws BadTypeException if Type of entry is not STRING and getValue() is called
   */
  public String getString() throws BadTypeException {
    if (this.type == Type.STRING) {
      return string;
    } else {
      throw new BadTypeException(
          "To use the function getString(), The Entry has to be of type STRING.");
    }
  }

  /**
   * Returns the Symbol value stored if the type of Entry is SYMBOL.
   * 
   * @return the Symbol stored in Entry.
   * @throws BadTypeException if Type of entry is not SYMBOL and getValue() is called
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.type == Type.SYMBOL) {
      return symbol;
    } else {
      throw new BadTypeException(
          "To use the function getSymbol(), The Entry has to be of type SYMBOL.");
    }
  }

  /**
   * Returns the type of the Entry object stored.
   * 
   * @return type of Entry
   */
  public Type getType() {
    return type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(string, symbol, type, value);
  }

  /**
   * Auto generated Java method that checks if two Entry objects are equal.
   * 
   * @param obj the Entry object to be compared to the Entry object stored
   * @return true if the two objects are equal
   */
  public boolean equals(Entry obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    return Objects.equals(string, other.string) && symbol == other.symbol && type == other.type
        && Float.floatToIntBits(value) == Float.floatToIntBits(other.value);
  }

}
