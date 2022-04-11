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

        relax1.setVisible(false);
        relax1.setManaged(false);
        relax2.setVisible(false);
        relax2.setManaged(false);
        relax3.setVisible(false);
        relax3.setManaged(false);
        sleep1.setVisible(false);
        sleep1.setManaged(false);
        sleep2.setVisible(false);
        sleep2.setManaged(false);
        sleep3.setVisible(false);
        sleep3.setManaged(false);
        creative1.setVisible(false);
        creative1.setManaged(false);
        creative2.setVisible(false);
        creative2.setManaged(false);
        creative3.setVisible(false);
        creative3.setManaged(false);
        calm1.setVisible(false);
        calm1.setManaged(false);
        calm2.setVisible(false);
        calm2.setManaged(false);
        calm3.setVisible(false);
        calm3.setManaged(false);
        happy1.setVisible(false);
        happy1.setManaged(false);
        happy2.setVisible(false);
        happy2.setManaged(false);
        happy3.setVisible(false);
        happy3.setManaged(false);


        //relax 1, sleep 1 , and ??
        if(valence>20 && valence<30 && arousal<-20 && arousal>-30){
            relax2.setVisible(true);
            relax2.setManaged(true);
            sleep1.setVisible(true);
            sleep1.setManaged(true);
        }

        //relax 2, sleep 2 , and ??
        else if(valence>10 && valence<20 && arousal>-16 && arousal<-10){
            relax1.setVisible(true);
            relax1.setManaged(true);
            sleep2.setVisible(true);
            sleep2.setManaged(true);
        }

        //relax 3, sleep 3 , and happy1
        else if(valence<10 && valence >0 && arousal>-10 && arousal < 2){
            relax3.setVisible(true);
            relax3.setManaged(true);
            sleep2.setVisible(true);
            sleep2.setManaged(true);
            happy1.setVisible(true);
            happy1.setManaged(true);
        }
        //creative and happy
        else if(valence<10 && valence>0 && arousal<10 && arousal>0){
            creative1.setVisible(true);
            creative1.setManaged(true);
            happy2.setVisible(true);
            happy2.setManaged(true);
        }

        //creative and happy
        else if(valence>10 && valence<17 && arousal>10 && arousal<14){
            creative1.setVisible(true);
            creative1.setManaged(true);
            happy3.setVisible(true);
            happy3.setManaged(true);
        }

        //calm1 and calm2 calm3
        else if(valence<3 && arousal>-3){
            calm1.setVisible(true);
            calm1.setManaged(true);
            calm2.setVisible(true);
            calm2.setManaged(true);
            calm3.setVisible(true);
            calm3.setManaged(true);
        }

//        // set the conditions for valence
//        if (valence > 17) {
//            creative.setVisible(false);
//            creative.setManaged(false);
//            calm.setVisible(false);
//            calm.setManaged(false);
//            if (valence > 26) {
//                happy.setVisible(false);
//                happy.setManaged(false);
//                sleep.setVisible(false);
//                sleep.setManaged(false);
//            }
//        } else if (valence < 3) {
//            creative.setVisible(false);
//            creative.setManaged(false);
//            if (valence < 1) {
//                relax.setVisible(false);
//                relax.setManaged(false);
//                happy.setVisible(false);
//                happy.setManaged(false);
//            }
//            if (valence < -5) {
//                sleep.setVisible(false);
//                sleep.setManaged(false);
//            }
//        } else {
//            calm.setVisible(false);
//            calm.setManaged(false);
//        }
//
//        // set the conditions for arousal values
//        if (arousal > -1) {
//            sleep.setVisible(false);
//            sleep.setManaged(false);
//            if (arousal > 2) {
//                relax.setVisible(false);
//                relax.setManaged(false);
//            }
//            if (arousal > 14) {
//                creative.setVisible(false);
//                creative.setManaged(false);
//            }
//            if (arousal > 21) {
//                happy.setVisible(false);
//                happy.setManaged(false);
//            }
//        } else {
//            creative.setVisible(false);
//            creative.setManaged(false);
//            if (arousal < -3) {
//                calm.setVisible(false);
//                calm.setManaged(false);
//                happy.setVisible(false);
//                happy.setManaged(false);
//            }
//            if (arousal < -27) {
//                relax.setVisible(false);
//                relax.setManaged(false);
//            }
//        }

    }



}
