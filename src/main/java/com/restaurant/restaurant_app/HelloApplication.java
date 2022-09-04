package com.restaurant.restaurant_app;

import com.restaurant.restaurant_app.controllers.DataController;
import com.restaurant.restaurant_app.data.DAO;
import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.entities.Pizza;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.ui.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, CloneNotSupportedException {
        MainGUI mainGui = new MainGUI(stage);
        Scene scene = new Scene(mainGui.getRoot(), 1920, 1024);
        stage.setTitle("Restaurant App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}