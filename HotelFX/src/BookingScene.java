package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookingScene {

    public void start(Stage stage) {
        ComboBox<String> cbRoomType = new ComboBox<>();
        cbRoomType.getItems().addAll(
                "1. Luxury Double Room",
                "2. Deluxe Double Room",
                "3. Luxury Single Room",
                "4. Deluxe Single Room"
        );

        ComboBox<Integer> cbRoomNo = new ComboBox<>();
        cbRoomNo.setPromptText("Select Room Number");

        Label lblStatus = new Label();
        Button btnBook = new Button("Book");

        // When room type is selected, populate room numbers
        cbRoomType.setOnAction(e -> {
            cbRoomNo.getItems().clear();
            int type = cbRoomType.getSelectionModel().getSelectedIndex() + 1;

            int start = switch (type) {
                case 1 -> 1;
                case 2 -> 11;
                case 3 -> 31;
                case 4 -> 41;
                default -> 1;
            };
            int end = switch (type) {
                case 1, 3 -> start + 10;   // 10 rooms
                case 2, 4 -> start + 20;   // 20 rooms
                default -> start;
            };
            for (int i = start; i < end; i++) {
                cbRoomNo.getItems().add(i);
            }
        });

        btnBook.setOnAction(e -> {
            try {
                int roomType = cbRoomType.getSelectionModel().getSelectedIndex() + 1;
                Integer roomNo = cbRoomNo.getValue();

                if (roomNo == null) {
                    lblStatus.setText("Please select a room number.");
                    return;
                }

                int rn = switch (roomType) {
                    case 1 -> roomNo - 1;
                    case 2 -> roomNo - 11;
                    case 3 -> roomNo - 31;
                    case 4 -> roomNo - 41;
                    default -> -1;
                };

                if (rn < 0) {
                    lblStatus.setText("Invalid room number.");
                    return;
                }

                new CustomerForm().start(stage, roomType, rn);
            } catch (Exception ex) {
                lblStatus.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10, new Label("Room Type:"), cbRoomType,
                new Label("Room Number:"), cbRoomNo,
                btnBook, lblStatus);
        layout.setStyle("-fx-padding: 20;");
        stage.setScene(new Scene(layout, 350, 300));
        stage.setTitle("Room Booking");
        stage.show();
    }
}
