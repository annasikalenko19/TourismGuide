package com.example.oop.GUI.authentication;

import java.net.URL;
import java.util.ResourceBundle;
import com.example.oop.logic.ChangeScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WelcomePage  implements Initializable {

    ChangeScene changeScene = new ChangeScene();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logOutButton;

    @FXML
    private Button startJourneyButton;

    @FXML
    private Label welcomeText;

    @FXML
    void initialize() {
    }
    public void setWelcomeText(String username){
        welcomeText.setText("Welcome "+username+" to our app!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene.changeScene(event,"/hello-view.fxml");
            }
        });
        startJourneyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChangeScene.sceneLogIn(event,"/log-in-page.fxml");
            }
        });
    }
}
