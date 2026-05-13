package com.example.oop.logic.map.station;

import com.example.oop.logic.user.Admin;
import com.example.oop.logic.user.CafeAdmin;
import com.example.oop.logic.user.HotelAdmin;

public class Hotel extends Station {
    @Override
    protected void displayServices() {
        System.out.println("Hotel services");
        throw new UnsupportedOperationException();
    }

    @Override
    public Admin getAdmin() {
        return new HotelAdmin();
    }

    public Hotel(double x,double y) {
        super(x, y, new HotelAdmin());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
