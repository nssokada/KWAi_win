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

public class loginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

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
    }



    @FXML
    void home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}
