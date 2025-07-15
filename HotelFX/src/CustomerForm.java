package org.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerForm {
    public void start(Stage stage, int roomType, int roomNo) {
        TextField tfName1 = new TextField();
        TextField tfContact1 = new TextField();
        ComboBox<String> cbGender1 = new ComboBox<>();
        cbGender1.getItems().addAll("Male", "Female", "Other");
        cbGender1.setPromptText("Select Gender");

        TextField tfName2 = new TextField();
        TextField tfContact2 = new TextField();
        ComboBox<String> cbGender2 = new ComboBox<>();
        cbGender2.getItems().addAll("Male", "Female", "Other");
        cbGender2.setPromptText("Select Gender");

        Label lblStatus = new Label();

        VBox layout = new VBox(10,
                new Label("Customer 1 Name:"), tfName1,
                new Label("Contact:"), tfContact1,
                new Label("Gender:"), cbGender1
        );

        if (roomType < 3) {
            layout.getChildren().addAll(
                    new Label("Customer 2 Name:"), tfName2,
                    new Label("Contact:"), tfContact2,
                    new Label("Gender:"), cbGender2
            );
        }

        Button btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(e -> {
            try {
                if (roomType < 3) {
                    Hotel.hotel_ob.luxury_doubleroom[roomNo] = new doubleroom(
                            tfName1.getText(), tfContact1.getText(), cbGender1.getValue(),
                            tfName2.getText(), tfContact2.getText(), cbGender2.getValue()
                    );
                } else {
                    Hotel.hotel_ob.luxury_singleroom[roomNo] = new singleroom(
                            tfName1.getText(), tfContact1.getText(), cbGender1.getValue()
                    );
                }
                lblStatus.setText("Room Booked!");
            } catch (Exception ex) {
                lblStatus.setText("Error: " + ex.getMessage());
            }
        });

        layout.getChildren().addAll(btnSubmit, lblStatus);
        layout.setStyle("-fx-padding: 20;");

        ScrollPane scroll = new ScrollPane(layout);
        scroll.setFitToWidth(true);
        stage.setScene(new Scene(scroll, 350, 400));
        stage.setTitle("Customer Details");
        stage.show();
    }
}
