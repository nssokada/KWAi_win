package com.example.kwai_win;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import processing.core.PApplet;

import java.io.IOException;

public class ListenCotroller {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Parent rooter;


    @FXML
    void home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void creativity(ActionEvent event) throws IOException {
        PApplet.main("creativity");
    }

    @FXML
    void calm(ActionEvent event) throws IOException {
        PApplet.main("Calm");
    }

    @FXML
    void sleep(ActionEvent event) throws IOException {
        PApplet.main("sleep");
    }

    @FXML
    void relax(ActionEvent event) throws IOException {
        PApplet.main("Relax");
    }

    @FXML
    void happy(ActionEvent event) throws IOException {
        PApplet.main("happyMat");
    }
}
