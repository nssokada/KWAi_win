package com.example.kwai_win;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public static KWAiUser user = new KWAiUser();

    @FXML
    private Parent rooter;

    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessagelabel;
    @FXML
    private TextField usernameTextfield;
    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonAction(ActionEvent e){

        if(usernameTextfield.getText().isBlank() == false && passwordPasswordField.getText().isBlank() ==false){
            //loginMessagelabel.setText("Incorrect password / username. Please try again");

            validateLogin();
        }
        else{
            loginMessagelabel.setText("Please enter username and password");
        }

    }

    //TODO
    public void validateLogin(){
        //please implement login with database here
        //here is a helpful sample: https://www.youtube.com/watch?v=J0IE5LRyzx8
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String verifyLogin = "SELECT count(1) FROM User WHERE username = '" + usernameTextfield.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult  = statement.executeQuery(verifyLogin);

            while(queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessagelabel.setText("Welcome! Click on our logo to continue.");
                    user.setName(usernameTextfield.getText());
                } else {
                    loginMessagelabel.setText("Invalid Login. Please try again.");
                }
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void signupButtonAction(ActionEvent e){

        //todo

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






}
