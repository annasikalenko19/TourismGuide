package com.example.oop.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.oop.logic.ChangeScene;
import com.example.oop.logic.database.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController implements Initializable {

    Utils dbUtils = Utils.getInstance();
    ChangeScene changeScene = new ChangeScene();

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button logInButton;

        @FXML
        private PasswordField passwordField;

        @FXML
        private Button signUpButton;

        @FXML
        private TextField userNameField;

//        @FXML
//        private ChoiceBox<String> choiceBoxFrom;
//
//        @FXML
//        private ChoiceBox<String> choiceBoxTo;
        @FXML
        void initialize() {


        }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

//    public HelloController(ChoiceBox<String> choiceBoxFrom) {
//        this.choiceBoxFrom = choiceBoxFrom;
//    }

    public TextField getUserNameField() {
        return userNameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setUserNameField(TextField userNameField) {
        this.userNameField = userNameField;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signUpButton.setOnAction(actionEvent -> {

            signUpButton.getScene().getWindow().hide();

            changeScene.sceneSignUp(actionEvent,"/com/example/oop/sign-up-page.fxml");

        });
        logInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                dbUtils.logInUser(event,userNameField.getText(),passwordField.getText());

            }
        });


     //   choiceBoxFrom.getItems().addAll(centers[0]);
    }
}
//trying to commit
