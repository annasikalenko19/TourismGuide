package com.example.oop.logic.map.station;

import com.example.oop.GUI.TripMap;
import com.example.oop.logic.user.Admin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public abstract class Station {
    public static final int ICON_SIZE = 38;
    public static final int CAFE = 1;
    public static final int GAS_STATION = 2;
    public static final int HOTEL = 4;
    public static final int EMERGENCY_ROOM = 8;
    public final double x ;
    public final double y ;
    protected final Admin admin;
    protected Station(double x, double y, Admin admin) {
        this.x = x;
        this.y = y;
        this.admin = admin;
    }
    protected abstract void displayServices();
    //implements template method pattern
    public void processOrder(){
        //TODO :station.processOrder()
        displayServices();
        throw new UnsupportedOperationException();
    }

    public abstract Admin getAdmin();

    public static enum Icon{
        CAFE(("/images/stations/cafe.png")),
        FIRST_AID(("/images/stations/firstAid.png")),
        HOTEL(("/images/stations/hotel.png")),
        GAS_STATION(("/images/stations/gasStation.png"));

        private final String icon;

        Icon(String icon) {
            this.icon = icon;
        }
        public static ImageView of (String fileName){
            Image image = new Image(Objects.requireNonNull(TripMap.class.getResourceAsStream(fileName)));
            return new ImageView(image);
        }

        public ImageView getIcon() {
            return of(icon);
        }
    }

}
