package com.example.oop.logic.user;

public class CafeAdmin extends Admin {
    //polymorphism
    public CafeAdmin(){
        super("Cafe","What do you want to order?",
                new String[]{"coffee","hot dog","water","soda"});
    }

    @Override
    public void serve(Traveler traveler) {
        throw new UnsupportedOperationException();
    }



}
