package com.example.oop;

import com.example.oop.logic.database.Utils;
import com.example.oop.logic.user.UserInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Cherkasy coordinates on map x = 682.000000, y = 299.000000
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/hello-view.fxml"));
        System.out.println("HelloApplication.class.getResource(\"hello-view.fxml\") = " + HelloApplication.class.getResource("hello-view.fxml"));
        System.out.println("fxmlLoader = " + fxmlLoader);
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}