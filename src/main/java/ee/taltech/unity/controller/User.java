package ee.taltech.unity.controller;

import lombok.*;

@Data
public class User {

    private String name;
    private String surname;

    public User(String name) {
        this.name = name;
    }

}
