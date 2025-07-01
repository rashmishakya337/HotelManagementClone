package org.example;

public class doubleroom extends singleroom {
    String name2;
    String contact2;
    String gender2;

    public doubleroom() {
        this.name = "";
        this.name2 = "";
    }

    public doubleroom(String name, String contact, String gender, String name2, String contact2, String gender2) {
        super(name, contact, gender);
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
    }
}
