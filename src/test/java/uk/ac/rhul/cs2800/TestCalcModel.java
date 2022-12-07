package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  private CalcModel calcModel;
  
  @BeforeEach
  void setup() {
    calcModel = new CalcModel();
  }

  @Test
  void testCalcModel() {
    assertNotEquals(calcModel.rpCalc, null, "RevPolishCalc object should be initialised.");
    assertNotEquals(calcModel.stCalc, null, "StandardCalc object should be initialised.");
  }

}
