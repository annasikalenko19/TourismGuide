package com.example.oop.GUI.trip;

import javafx.fxml.FXML;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TripController implements Initializable {



    @FXML
    private Button confirmBtn;

    @FXML
    private ChoiceBox<String> offers;

    @FXML
    private Text question;

    @FXML
    private Text title;

    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}