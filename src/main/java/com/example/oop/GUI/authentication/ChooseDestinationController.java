package com.example.oop.GUI.authentication;


import java.net.URL;
import java.util.ResourceBundle;

import com.example.oop.GUI.TripMap;
import com.example.oop.logic.ChangeScene;
import com.example.oop.logic.database.Utils;
import com.example.oop.logic.exception.PlaceNotSelectedException;
import com.example.oop.logic.map.station.Station;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class ChooseDestinationController implements Initializable {

    Utils dbUtils = Utils.getInstance();
    ChangeScene changeScene = new ChangeScene();
    @FXML
    private Button buttonShowMap;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private CheckBox cafeCheckBox;

    @FXML
    private CheckBox emergencyRoomCheckBox;

    @FXML
    private CheckBox gasStationCheckBox;

    @FXML
    private CheckBox hotelCheckBox;
    @FXML
    private TextField inputFromField;

    @FXML
    private TextField inputToField;

    @FXML
    private Button startTripButton;
    @FXML
    private Button logOutButton;
    @FXML
    private ChoiceBox<String> choiceBoxFrom;

    @FXML
    private ChoiceBox<String> choiceBoxTo;

    public String[] centers = {"Cherkasy","Chernihiv","Chernivtsi","Dnipro","Donetsk","Ivano-Frankivsk","Kharkiv","Kherson","Khmelnytskyi","Kropyvnytskyi","Kyiv","Luhansk","Lutsk","Lviv","Mykolaiv","Odesa","Poltava","Rivne","Sumy","Ternopil","Uzhhorod","Vinnytsia","Zaporizhzhia","Zhytomyr","Simferopol"};
    public String[] destinations = {"Tunnel of Love","Askania-Nova","Aktove canyon","Synevyr","Hoverla","Kamianets-Podilskyi Castle","Dnieper–Bug estuary","Oleshky Sands","Shatsky Lakes"};

    @FXML
    void initialize() {

    }
    @FXML
    private void showTripMap() {

        int n = (cafeCheckBox.isSelected() ? Station.CAFE : 0 ) |
                (gasStationCheckBox.isSelected() ? Station.GAS_STATION : 0 ) |
                (emergencyRoomCheckBox.isSelected() ? Station.EMERGENCY_ROOM : 0 ) |
                (hotelCheckBox.isSelected() ? Station.HOTEL : 0 ) ;

        System.out.println("Stations n = " + n);
        try {
            new TripMap(choiceBoxFrom.getValue(),choiceBoxTo.getValue(),n);
        } catch (PlaceNotSelectedException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please choose from and to!");
            alert.show();;
        }
    }
    @FXML
    private void showMap() {
        TripMap.showMapOnly();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene.changeScene(event,"/com/example/oop/hello-view.fxml");
            }
        });

        choiceBoxFrom.getItems().addAll(centers);
        choiceBoxTo.getItems().addAll(destinations);
        buttonShowMap.setOnAction(event -> showMap());

    }
    @FXML
    protected void buildPath(){
        System.out.println(cafeCheckBox.isSelected());
        System.out.println(hotelCheckBox.isSelected());
        System.out.println(emergencyRoomCheckBox.isSelected());
        System.out.println(gasStationCheckBox.isSelected());
    }

}
