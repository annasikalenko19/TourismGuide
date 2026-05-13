package com.example.oop.logic.map.station;

import com.example.oop.logic.user.Admin;
import com.example.oop.logic.user.CafeAdmin;

public class Cafe extends Station{
    @Override
    protected void displayServices() {
        System.out.println("cafe services");
        throw new UnsupportedOperationException();
    }

    @Override
    public Admin getAdmin() {
        return new CafeAdmin();
    }


    public Cafe(double x,double y) {
        super(x, y, new CafeAdmin());
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "x=" + x +
                ", y=" + y +

                '}';
    }
}
