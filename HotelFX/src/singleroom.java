package org.example;

import java.util.ArrayList;

public class singleroom {
    String name;
    String contact;
    String gender;
    ArrayList<Food> food = new ArrayList<>();

    public singleroom(String name, String contact, String gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
}
