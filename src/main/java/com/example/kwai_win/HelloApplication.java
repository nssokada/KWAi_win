package com.example.kwai_win;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Stage primaryStage  = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
      //      primaryStage.setResizable(false);   @team do we want to implement this
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}