package org.example;

public class doubleroom extends singleroom {
    String name2, contact2, gender2;

    public doubleroom(String name1, String contact1, String gender1,
                      String name2, String contact2, String gender2) {
        super(name1, contact1, gender1);
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
    }
}
