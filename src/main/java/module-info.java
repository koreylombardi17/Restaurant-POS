module com.restaurant.restaurant_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.restaurant.restaurant_app to javafx.fxml;
    exports com.restaurant.restaurant_app;
    exports com.restaurant.restaurant_app.entities;
    opens com.restaurant.restaurant_app.entities to javafx.fxml;
    exports com.restaurant.restaurant_app.data;
    opens com.restaurant.restaurant_app.data to javafx.fxml;
    exports com.restaurant.restaurant_app.controllers;
    opens com.restaurant.restaurant_app.controllers to javafx.fxml;
}