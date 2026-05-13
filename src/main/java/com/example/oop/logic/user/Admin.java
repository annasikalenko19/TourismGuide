package com.example.oop.logic.user;

public abstract class Admin implements User {
    public final String stationName;
    public final String question;
    public final String[] offers;

    public Admin(String stationName, String question, String[] offers) {
        this.stationName = stationName;
        this.question = question;
        this.offers = offers;
    }


    public abstract void serve(Traveler traveler);

    public void showAvailableServices(){
        System.out.println(stationName);
        for (var offer:
             offers) {
            System.out.println(" - " + offer);
        }
    }



}
