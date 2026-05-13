package com.example.oop.logic.user;

public interface User {

   // default method implementation
    default void displayUserInfo() {
        System.out.println(this);
    }
}
