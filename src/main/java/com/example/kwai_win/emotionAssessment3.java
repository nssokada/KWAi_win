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

public class emotionAssessment3 implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label lbl1;
    public static Label static_label;
    @FXML
    private Button calm;
    @FXML
    private Button happy;
    @FXML
    private Button creative;
    @FXML
    private Button relax;
    @FXML
    private Button sleep;

    @FXML
    private Parent rooter;

    private int valence;
    private int arousal;

    KWAiUser user = loginController.user;

    @FXML
    void home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
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
            creative.setVisible(false);
            creative.setManaged(false);
            calm.setVisible(false);
            calm.setManaged(false);
            if (valence > 26) {
                happy.setVisible(false);
                happy.setManaged(false);
                sleep.setVisible(false);
                sleep.setManaged(false);
            }
        } else if (valence < 3) {
            creative.setVisible(false);
            creative.setManaged(false);
            if (valence < 1) {
                relax.setVisible(false);
                relax.setManaged(false);
                happy.setVisible(false);
                happy.setManaged(false);
            }
            if (valence < -5) {
                sleep.setVisible(false);
                sleep.setManaged(false);
            }
        } else {
            calm.setVisible(false);
            calm.setManaged(false);
        }

        // set the conditions for arousal values
        if (arousal > -1) {
            sleep.setVisible(false);
            sleep.setManaged(false);
            if (arousal > 2) {
                relax.setVisible(false);
                relax.setManaged(false);
            }
            if (arousal > 14) {
                creative.setVisible(false);
                creative.setManaged(false);
            }
            if (arousal > 21) {
                happy.setVisible(false);
                happy.setManaged(false);
            }
        } else {
            creative.setVisible(false);
            creative.setManaged(false);
            if (arousal < -3) {
                calm.setVisible(false);
                calm.setManaged(false);
                happy.setVisible(false);
                happy.setManaged(false);
            }
            if (arousal < -27) {
                relax.setVisible(false);
                relax.setManaged(false);
            }
        }

    }



}
