package com.example.kwai_win;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import processing.core.PApplet;

import java.io.IOException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Parent rooter;

    public int valence = 0;
    public int arousal = 0;

    @FXML
    void emotionControl(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("emotionAssessment.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void userDashboard(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("userdashboard.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void showNextScreen(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void customization(ActionEvent event) throws IOException{
        PApplet.main("my_audio_visualizer");
    }

    @FXML
    void listen(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("listen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotoPreset(ActionEvent event) {
        Button button = (Button) event.getSource();

        String preset = button.getText();
        System.out.println(preset);
    }
}