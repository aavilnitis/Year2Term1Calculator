package uk.ac.rhul.cs2800;

import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Calculator view class that handles all of the GUI events of Calculator.
 * 
 * @author aleksisvilnitis
 */
public class CalcView {
  private boolean infix;
  private String expression;
  private String result;
  private String first;
  private String second;
  private CalcModel caModel;
  private Alert alert;
  private Scanner scanner;


  /**
   * Method that sets all of the fields and values to a starting state.
   */
  @FXML
  public void initialize() {
    result = "";
    expression = "";
    infix = false;

    textFieldResult.setText("");
    textFieldExpression.setText("");
    radioPostfix.setSelected(false);
    radioInfix.setSelected(false);

    // Unselect textFieldExpression
    Platform.runLater(() -> backgroundAnchor.requestFocus());

    // Allert for expression errors
    alert = new Alert(AlertType.INFORMATION);
  }

  @FXML
  private AnchorPane backgroundAnchor;

  @FXML
  private Button calculateButton;

  @FXML
  private RadioButton radioInfix;

  @FXML
  private RadioButton radioPostfix;

  @FXML
  private TextArea textFieldExpression;

  @FXML
  private TextArea textFieldResult;

  @FXML
  void isInfix(ActionEvent event) {
    infix = true;
  }

  @FXML
  void isPostfix(ActionEvent event) {
    infix = false;
  }

  @FXML
  void isPressed(ActionEvent event) throws Exception {
    caModel = new CalcModel();
    expression = textFieldExpression.getText();
    if ((infix && isInfixString(expression)) || (!infix && !isInfixString(expression))) {
      textFieldResult.setText(calculate(expression, infix));
    } else if (infix) {
      textFieldResult.setText("Expression not in Infix");
    } else {
      textFieldResult.setText("Expression not in Postfix");
    }

  }

  @FXML
  void mouseEnter(MouseEvent event) {
    textFieldResult.setText("");
  }

  @FXML
  void clearFields(ActionEvent event) {
    initialize();
  }

  private String calculate(String expression, boolean infix) {
    try {
      result = Float.toString(caModel.evaluate(expression, infix));
    } catch (Exception e) {
      alert.setContentText("Invalid expression, please try again!");
      alert.show();
      initialize();
    }
    return result;
  }

  private boolean isInfixString(String expression) {
    scanner = new Scanner(expression);
    first = scanner.next();
    second = scanner.next();

    if (first.equals("(")) {
      return true;
    } else if (caModel.rpCalc.isNumeric(first) && caModel.rpCalc.isOperator(second)) {
      return true;
    }
    return false;
  }


}
