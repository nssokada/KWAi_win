package com.example.kwai_win;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class emotionAssessment1 implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public int valence = 0;
    public int arousal = 0;

    @FXML
    private Parent rooter;

    public static KWAiUser user =new KWAiUser(0,0);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    void one(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        user.setValence(1);
        user.setArousal(1);
    }

    @FXML
    void two(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        user.setValence(2);
        user.setArousal(2);
    }

    @FXML
    void three(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        user.setValence(3);
        user.setArousal(3);;

    }

    @FXML
    void four(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        user.setValence(4);
        user.setArousal(4);
    }

    @FXML
    void five(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        user.setValence(5);
        user.setArousal(5);
    }

    @FXML
    void six(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        user.setValence(6);
        user.setArousal(6);
    }

    @FXML
    void seven(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        user.setValence(7);
        user.setArousal(7);
    }
    @FXML
    void eight(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        user.setValence(8);
        user.setArousal(8);
    }

    @FXML
    void nine(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment2.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        user.setValence(9);
        user.setArousal(9);
    }


    @FXML
    void home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
