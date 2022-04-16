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
import java.sql.Connection;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class emotionAssessment2 implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    KWAiUser user = loginController.user;

    @FXML
    private Parent rooter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

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

    @FXML
    void calm(ActionEvent event) throws IOException {
        user.addValence(6);
        user.addArousal(-6);
    }

    @FXML
    void content(ActionEvent event) throws IOException {
        user.addValence(10);
       user.addArousal(-7);
    }


    @FXML
    void bored(ActionEvent event) throws IOException {

        user.addValence(-3);
        user.addArousal(-8);

    }

    @FXML
    void worried(ActionEvent event) throws IOException {

        user.addValence(-2);
        user.addArousal(-3);

    }

    @FXML
    void distracted(ActionEvent event) throws IOException {
        user.addValence(-1);
        user.addArousal(3);
    }

    @FXML
    void focused(ActionEvent event) throws IOException {

        user.addValence(5);
        user.addArousal(-5);
    }

    @FXML
    void relaxed(ActionEvent event) throws IOException {
        user.addValence(6);
        user.addArousal(-10);
    }

    @FXML
    void angry(ActionEvent event) throws IOException {

        user.addValence(-5);
        user.addArousal(9);

    }

    @FXML
    void inspired(ActionEvent event) throws IOException {
        user.addValence(5);
        user.addArousal(5);
    }

    @FXML
    void frustrated(ActionEvent event) throws IOException {
        user.addValence(-5);
        user.addArousal(5);
    }



    @FXML
    void submitForm(ActionEvent event) throws IOException {
        try {
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                PreparedStatement preparedStatement = connectDB.prepareStatement("INSERT INTO Takes VALUES(?, ?, ?, ?, Now())");
                preparedStatement.setString(1, String.valueOf(user.getUID()));
                preparedStatement.setString(2, "3");
                preparedStatement.setString(3, String.valueOf(user.getArousal()));
                preparedStatement.setString(4, String.valueOf(user.getValence()));
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = FXMLLoader.load(getClass().getResource("emotionAssessment3.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
