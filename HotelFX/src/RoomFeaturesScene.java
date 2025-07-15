
package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoomFeaturesScene {
    public void start(Stage stage) {
        ComboBox<String> roomType = new ComboBox<>();
        roomType.getItems().addAll("1. Luxury Double", "2. Deluxe Double", "3. Luxury Single", "4. Deluxe Single");

        Label result = new Label();
        Button btnShow = new Button("Show");

        btnShow.setOnAction(e -> {
            switch (roomType.getSelectionModel().getSelectedIndex() + 1) {
                case 1 -> result.setText("Double beds: 1\nAC: Yes\nBreakfast: Yes\nRs.4000");
                case 2 -> result.setText("Double beds: 1\nAC: No\nBreakfast: Yes\nRs.3000");
                case 3 -> result.setText("Single bed: 1\nAC: Yes\nBreakfast: Yes\nRs.2200");
                case 4 -> result.setText("Single bed: 1\nAC: No\nBreakfast: Yes\nRs.1200");
                default -> result.setText("Select room type.");
            }
        });

        VBox layout = new VBox(10, roomType, btnShow, result);
        layout.setStyle("-fx-padding: 20;");
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Room Features");
        stage.show();
    }
}
