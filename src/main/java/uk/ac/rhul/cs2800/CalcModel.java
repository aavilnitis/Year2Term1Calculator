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

  public float evaluate(String expression, boolean infix) throws Exception {
    if(infix) {
      return stCalc.evaluate(expression);
    }
    return rpCalc.evaluate(expression);
  }

}
