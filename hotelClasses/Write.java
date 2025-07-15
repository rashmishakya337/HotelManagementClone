package org.example;


import java.io.*;

public class Write implements Runnable {
    Holder hotel_ob;

    public Write(Holder hotel_ob) {
        this.hotel_ob = hotel_ob;
    }

    @Override
    public void run() {
        try {
            FileOutputStream fout = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        } catch (Exception e) {
            System.out.println("Error in writing " + e);
        }
    }
}
