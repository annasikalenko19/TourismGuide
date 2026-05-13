package com.example.oop.logic.map.station;

import com.example.oop.logic.user.Admin;
import com.example.oop.logic.user.CafeAdmin;
import com.example.oop.logic.user.EmergencyRoomAdmin;

public class EmergencyRoom extends Station{
    @Override
    protected void displayServices() {
        System.out.println("Emergency room services");
        throw new UnsupportedOperationException();
    }

    @Override
    public Admin getAdmin() {
        return new EmergencyRoomAdmin();
    }

    public EmergencyRoom(double x,double y) {
        super(x, y, new EmergencyRoomAdmin());
    }

    @Override
    public String toString() {
        return "EmergencyRoom{" +
                "x=" + x +
                ", y=" + y +

                '}';
    }
}
