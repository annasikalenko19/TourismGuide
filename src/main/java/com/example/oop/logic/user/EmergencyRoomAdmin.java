package com.example.oop.logic.user;

public class EmergencyRoomAdmin extends Admin{
    public EmergencyRoomAdmin(){
        super("Emergency Room","What kind of help do you need?",
                new String[]{"headache","stomachache"});
    }

    @Override
    public void serve(Traveler traveler) {
        throw new UnsupportedOperationException();
    }


}
