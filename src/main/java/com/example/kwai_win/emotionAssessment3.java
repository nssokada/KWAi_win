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
import processing.core.PApplet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class emotionAssessment3 implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label lbl1;
    public static Label static_label;

    @FXML
    private Button calm1;
    @FXML
    private Button calm2;
    @FXML
    private Button calm3;

    @FXML
    private Button happy1;
    @FXML
    private Button happy2;
    @FXML
    private Button happy3;

    @FXML
    private Button creative1;
    @FXML
    private Button creative2;
    @FXML
    private Button creative3;

    @FXML
    private Button relax1;
    @FXML
    private Button relax2;
    @FXML
    private Button relax3;

    @FXML
    private Button sleep1;
    @FXML
    private Button sleep2;
    @FXML
    private Button sleep3;

    @FXML
    private Parent rooter;

    private int valence;
    private int arousal;

    KWAiUser user = loginController.user;

    @FXML
    void home(ActionEvent event) throws IOException {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        valence = user.getValence();
        arousal = user.getArousal();


        // set the conditions for valence
        if (valence > 17) {
            creative1.setVisible(false);
            creative1.setManaged(false);
            calm1.setVisible(false);
            calm1.setManaged(false);
            if (valence > 26) {
                sleep1.setVisible(false);
                sleep1.setManaged(false);
                happy1.setVisible(false);
                happy1.setManaged(false);
            }
        } else if (valence < 4) {
            creative1.setVisible(false);
            creative1.setManaged(false);
            if (valence < 1) {
                relax1.setVisible(true);
                relax1.setManaged(true);
                happy1.setVisible(false);
                happy1.setManaged(false);
            }
            if (valence < -5) {
                sleep1.setVisible(false);
                sleep1.setManaged(false);
            }
        } else {
            calm1.setVisible(false);
            calm1.setManaged(false);
        }

        // set the conditions for arousal values
        if (arousal > -1) {
            sleep1.setVisible(false);
            sleep1.setManaged(false);
            if (arousal > 2) {
                relax1.setVisible(false);
                relax1.setManaged(false);
            }
            if (arousal > 14) {
                creative1.setVisible(false);
                creative1.setManaged(false);
            }
            if (arousal > 21) {
                happy1.setVisible(false);
                happy1.setManaged(false);
            }
        } else {
            creative1.setVisible(false);
            creative1.setManaged(false);
            if (arousal < -3) {
                calm1.setVisible(false);
                calm1.setManaged(false);
                happy1.setVisible(false);
                happy1.setManaged(false);
            }
            if (arousal < -27) {
                relax1.setVisible(false);
                relax1.setManaged(false);
            }
        }

    }


    @FXML
    void creativity(ActionEvent event) throws IOException {
        PApplet.main("creativity");
    }

    @FXML
    void calm(ActionEvent event) throws IOException {
        PApplet.main("Calmer");
    }

    @FXML
    void sleep(ActionEvent event) throws IOException {
        PApplet.main("sleep");
    }

    @FXML
    void relax(ActionEvent event) throws IOException {
        PApplet.main("Relaxed");
    }

    @FXML
    void happy(ActionEvent event) throws IOException {
        PApplet.main("Happier");
    }




}
