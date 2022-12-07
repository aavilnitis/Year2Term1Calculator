package uk.ac.rhul.cs2800;

/**
 * CalcMOdel class that checks and calls the appropriate calculator model for the expression.
 * 
 * @author aleksisvilnitis
 */
public class CalcModel {
  protected RevPolishCalc rpCalc;
  protected StandardCalc stCalc;

  /**
   * Public constructor for CalcModel.
   */
  public CalcModel() {
    this.rpCalc = new RevPolishCalc();
    this.stCalc = new StandardCalc();
  }

  /**
   * Evaluate method that calls either RevPolishCalc or StandardCalc depending on param infix value.
   * 
   * @param expression the expression to be calculated
   * @param infix boolean value that tells if the expression is in postfix or not
   * @return float value of the result
   * @throws Exception when expression is invalid
   */
  public float evaluate(String expression, boolean infix) throws Exception {
    if (infix) {
      return stCalc.evaluate(expression);
    }
    return rpCalc.evaluate(expression);
  }

}
