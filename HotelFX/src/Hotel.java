package org.example;

public class Hotel {
    static Holder hotel_ob = new Holder();

    public static void deallocate(int rn, int rtype) {
        System.out.println("Room deallocated: RoomType " + rtype + ", Index " + rn);
        switch (rtype) {
            case 1 -> hotel_ob.luxury_doubleroom[rn] = null;
            case 2 -> hotel_ob.deluxe_doubleroom[rn] = null;
            case 3 -> hotel_ob.luxury_singleroom[rn] = null;
            case 4 -> hotel_ob.deluxe_singleroom[rn] = null;
        }
    }
}