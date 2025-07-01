package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class singleroom implements Serializable {
    String name;
    String contact;
    String gender;
    ArrayList<Food> food = new ArrayList<>();

    public singleroom() {
        this.name = "";
    }

    public singleroom(String name, String contact, String gender) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
}
