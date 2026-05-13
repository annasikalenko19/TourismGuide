package com.example.oop.logic.user;

public class HotelAdmin extends Admin{
    public HotelAdmin(){
        super("Hotel","How long do you want to stay here?",
                new String[]{"4 hours","1","2","3","4","5"});
    }

    @Override
    public void serve(Traveler traveler) {
        throw new UnsupportedOperationException();
    }

}
