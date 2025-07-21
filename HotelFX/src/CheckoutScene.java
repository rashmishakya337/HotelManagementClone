package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckoutScene {

    public void start(Stage stage) {
        ComboBox<Integer> cbRoom = new ComboBox<>();
        cbRoom.setPromptText("Select Room Number");

        Button btnCheckout = new Button("Checkout");
        Label lblStatus = new Label();

        // Add only booked rooms to the dropdown
        for (int i = 0; i < Hotel.hotel_ob.luxury_doubleroom.length; i++) {
            if (Hotel.hotel_ob.luxury_doubleroom[i] != null) cbRoom.getItems().add(i + 1);
        }
        for (int i = 0; i < Hotel.hotel_ob.deluxe_doubleroom.length; i++) {
            if (Hotel.hotel_ob.deluxe_doubleroom[i] != null) cbRoom.getItems().add(i + 11);
        }
        for (int i = 0; i < Hotel.hotel_ob.luxury_singleroom.length; i++) {
            if (Hotel.hotel_ob.luxury_singleroom[i] != null) cbRoom.getItems().add(i + 31);
        }
        for (int i = 0; i < Hotel.hotel_ob.deluxe_singleroom.length; i++) {
            if (Hotel.hotel_ob.deluxe_singleroom[i] != null) cbRoom.getItems().add(i + 41);
        }

        btnCheckout.setOnAction(e -> {
            try {
                Integer room = cbRoom.getValue();
                if (room == null) {
                    lblStatus.setText("⚠️ Please select a room.");
                    return;
                }

                int rtype, rn;
                if (room > 40) { rtype = 4; rn = room - 41; }
                else if (room > 30) { rtype = 3; rn = room - 31; }
                else if (room > 10) { rtype = 2; rn = room - 11; }
                else { rtype = 1; rn = room - 1; }

                // Check if the room is booked before deallocating
                boolean isBooked = switch (rtype) {
                    case 1 -> Hotel.hotel_ob.luxury_doubleroom[rn] != null;
                    case 2 -> Hotel.hotel_ob.deluxe_doubleroom[rn] != null;
                    case 3 -> Hotel.hotel_ob.luxury_singleroom[rn] != null;
                    case 4 -> Hotel.hotel_ob.deluxe_singleroom[rn] != null;
                    default -> false;
                };

                if (!isBooked) {
                    lblStatus.setText("⚠️ Room is already empty.");
                    return;
                }

                Hotel.deallocate(rn, rtype);
                lblStatus.setText("✅ Room " + room + " checked out.");
                cbRoom.getItems().remove(room);

            } catch (Exception ex) {
                lblStatus.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10, cbRoom, btnCheckout, lblStatus);
        layout.setStyle("-fx-padding: 20;");
        stage.setScene(new Scene(layout, 350, 200));
        stage.setTitle("Checkout");
        stage.show();
    }
}