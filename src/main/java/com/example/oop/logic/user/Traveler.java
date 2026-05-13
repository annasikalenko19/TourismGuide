package com.example.oop.logic.user;

import java.time.LocalDateTime;

public class Traveler implements User {

    private  String name;
    private  String from;
    private  String destination;

    private LocalDateTime departureTime;

    public Traveler(String name, String from, String destination) {
        this.name = name;
        this.from = from;
        this.destination = destination;
    }



}
