package com.example.oop.logic.user;

import java.io.Serializable;

public record UserInfo(String login, String password) implements Serializable {

}
