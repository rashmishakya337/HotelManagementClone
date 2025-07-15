package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FoodOrderScene {

    public void start(Stage stage) {
        ComboBox<Integer> cbRoom = new ComboBox<>();
        cbRoom.setPromptText("Select Room Number");

        ComboBox<String> cbItem = new ComboBox<>();
        cbItem.getItems().addAll("1. Sandwich - 50", "2. Pasta - 60", "3. Noodles - 70", "4. Coke - 30");
        cbItem.setPromptText("Select Food Item");

        TextField tfQty = new TextField();
        tfQty.setPromptText("Quantity");

        Button btnOrder = new Button("Order");
        Label lblStatus = new Label();

        // Populate room dropdown with all booked rooms
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

        btnOrder.setOnAction(e -> {
            try {
                Integer room = cbRoom.getValue();
                int item = cbItem.getSelectionModel().getSelectedIndex() + 1;
                int qty = Integer.parseInt(tfQty.getText());

                if (room == null || item < 1 || qty < 1) {
                    lblStatus.setText("Please fill all fields correctly.");
                    return;
                }

                int rtype, rn;
                if (room > 40) { rtype = 4; rn = room - 41; }
                else if (room > 30) { rtype = 3; rn = room - 31; }
                else if (room > 10) { rtype = 2; rn = room - 11; }
                else { rtype = 1; rn = room - 1; }

                // Check if room is booked
                switch (rtype) {
                    case 1:
                        if (Hotel.hotel_ob.luxury_doubleroom[rn] != null)
                            Hotel.hotel_ob.luxury_doubleroom[rn].food.add(new Food(item, qty));
                        else throw new Exception("Room not booked.");
                        break;
                    case 2:
                        if (Hotel.hotel_ob.deluxe_doubleroom[rn] != null)
                            Hotel.hotel_ob.deluxe_doubleroom[rn].food.add(new Food(item, qty));
                        else throw new Exception("Room not booked.");
                        break;
                    case 3:
                        if (Hotel.hotel_ob.luxury_singleroom[rn] != null)
                            Hotel.hotel_ob.luxury_singleroom[rn].food.add(new Food(item, qty));
                        else throw new Exception("Room not booked.");
                        break;
                    case 4:
                        if (Hotel.hotel_ob.deluxe_singleroom[rn] != null)
                            Hotel.hotel_ob.deluxe_singleroom[rn].food.add(new Food(item, qty));
                        else throw new Exception("Room not booked.");
                        break;
                }

                lblStatus.setText("✅ Order placed!");
            } catch (NumberFormatException nfe) {
                lblStatus.setText("Quantity must be a number.");
            } catch (Exception ex) {
                lblStatus.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10, cbRoom, cbItem, tfQty, btnOrder, lblStatus);
        layout.setStyle("-fx-padding: 20;");
        stage.setScene(new Scene(layout, 350, 250));
        stage.setTitle("Food Order");
        stage.show();
    }
}
