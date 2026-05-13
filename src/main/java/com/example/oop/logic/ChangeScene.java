package com.example.oop.logic;

import com.example.oop.GUI.AdminPage;
import com.example.oop.GUI.HelloController;
import com.example.oop.GUI.authentication.ChooseDestinationController;
import com.example.oop.GUI.authentication.SignUpPage;
import com.example.oop.GUI.authentication.WelcomePage;
import com.example.oop.logic.database.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeScene {

    public void changeScene(ActionEvent event, String fxmlFile, String username){
        Parent root = null;
        if(username != null){
            try {
                var location = Utils.class.getResource(fxmlFile);
                System.out.println(location);
                FXMLLoader loader = new FXMLLoader(location);
                root = loader.load();
                WelcomePage welcomePage = loader.getController();
                welcomePage.setWelcomeText(username);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root,700,400));
        stage.show();
    }
    public  void changeScene(ActionEvent event,String fxmlFile){
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxmlFile));
            root = loader.load();
            HelloController helloController = loader.getController();
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root,700,400));
        stage.show();
    }
    public static void sceneLogIn(ActionEvent event,String fxmlFile){

        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxmlFile));
            root = loader.load();
            ChooseDestinationController logInPage = loader.getController();
        }catch (IOException e){
            System.out.println("EXEPTION"); System.out.println("EXEPTION"); System.out.println("EXEPTION");
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root,700,400));
        stage.show();
    }
    public void sceneSignUp(ActionEvent event,String fxmlFile){

        Parent root = null;
        try {
            var location = getClass().getResource(fxmlFile);
            System.out.println(location);
            FXMLLoader loader = new FXMLLoader(location);
            root = loader.load();
            SignUpPage signUpPage= loader.getController();
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root,700,400));
        stage.show();
    }
    public  void sceneAdmin(ActionEvent event,String fxmlFile){

        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxmlFile));
            root = loader.load();
            AdminPage adminPage= loader.getController();
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root,700,400));
        stage.show();
    }

}
