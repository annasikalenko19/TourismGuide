package com.example.oop.logic.map.station;

import com.example.oop.logic.user.Admin;
import com.example.oop.logic.user.CafeAdmin;
import com.example.oop.logic.user.GasStationAdmin;

public class GasStation extends Station{
    @Override
    protected void displayServices() {
        System.out.println("Gas Station services");
        throw new UnsupportedOperationException();
    }

    @Override
    public Admin getAdmin() {
        return new GasStationAdmin();
    }

    public GasStation(double x,double y) {
        super(x, y, new GasStationAdmin());
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
