package com.example.oop.logic.user;

public class GasStationAdmin extends Admin{
    public GasStationAdmin(){
        super("Gas Station","What kind of gas do you need?",
                new String[]{"95","disel","92"});
    }

    @Override
    public void serve(Traveler traveler) {
        throw new UnsupportedOperationException();
    }


}
