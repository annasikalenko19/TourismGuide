package com.example.oop.GUI.authentication;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.oop.logic.ChangeScene;
import com.example.oop.logic.database.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpPage implements Initializable {
    Utils dbUtils = Utils.getInstance();
    ChangeScene changeScene = new ChangeScene();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameField;

    @FXML
    void initialize() {}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!usernameField.getText().trim().isEmpty() &&  !passwordField.getText().trim().isEmpty() ){
                dbUtils.signUpUser(event,usernameField.getText(),passwordField.getText());

                changeScene.changeScene(event,"/welcome-page.fxml", usernameField.getText());
                }else {
                    System.out.println("please,fill in information!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all the information to sign up!");
                    alert.show();;
                }
            }
        });
    }
}