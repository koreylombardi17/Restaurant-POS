package com.restaurant.restaurant_app;

import com.restaurant.restaurant_app.controllers.*;
import com.restaurant.restaurant_app.entities.ShoppingCart;
import com.restaurant.restaurant_app.ui.*;
import com.restaurant.restaurant_app.ui.listviews.CartItemsListView;
import com.restaurant.restaurant_app.ui.listviews.FoodItemsListView;
import com.restaurant.restaurant_app.ui.listviews.ModifiersItemsListView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, CloneNotSupportedException {
        // Shopping Cart to store current order
        ShoppingCart cart = new ShoppingCart();

        // Main controller object that contains all the other controllers
        MainController mainController = new MainController(cart);

        // Controls which scene is being displayed
        SceneController sceneController = new SceneController(stage, mainController);
        mainController.setSceneController(sceneController);
    }

    public static void main(String[] args) {
        launch();
    }
}