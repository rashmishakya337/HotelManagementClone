
package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HotelApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button btnBook = new Button("Book Room");
        btnBook.setOnAction(e -> new BookingScene().start(new Stage()));

        Button btnFeatures = new Button("Room Details");
        btnFeatures.setOnAction(e -> new RoomFeaturesScene().start(new Stage()));

        Button btnOrder = new Button("Order Food");
        btnOrder.setOnAction(e -> new FoodOrderScene().start(new Stage()));

        Button btnCheckout = new Button("Checkout");
        btnCheckout.setOnAction(e -> new CheckoutScene().start(new Stage()));

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> primaryStage.close());

        VBox root = new VBox(15, btnBook, btnFeatures, btnOrder, btnCheckout, btnExit);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Hotel Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
