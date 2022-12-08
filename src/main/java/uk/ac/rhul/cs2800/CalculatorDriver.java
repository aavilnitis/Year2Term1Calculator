package uk.ac.rhul.cs2800;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Driver class for Calculator program.
 * 
 * @author aleksisvilnitis
 */
public class CalculatorDriver extends Application {

  /**
   * Main method of Driver class.
   * 
   * @param args default args
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("calcView.fxml"));
    Scene scene = new Scene(root, 500, 300);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();   
  }
}
