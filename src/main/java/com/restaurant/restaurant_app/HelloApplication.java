package com.restaurant.restaurant_app;

import com.restaurant.restaurant_app.controllers.*;
import com.restaurant.restaurant_app.entities.ShoppingCart;
import com.restaurant.restaurant_app.ui.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, CloneNotSupportedException {
        // Shopping Cart Object
        ShoppingCart cart = new ShoppingCart();

        // Main controller object that contains all controllers
        MainController mainController = new MainController(cart);

        // Apps main gui that contains sub gui's
        MainGUI mainGui = new MainGUI(stage, mainController);
        mainController.getFoodItemsController().setMainGUI(mainGui);

        // Create CartGUI and link it to its required controllers
        CartGUI cartGUI = new CartGUI(mainGui, mainController.getCartController());
        mainController.getCartController().setCartGUI(cartGUI);

        // Create FoodCategoriesGUI, link it to its required controllers, set button's functionality
        FoodCategoriesGUI foodCategoriesGUI = new FoodCategoriesGUI();
        mainController.getFoodCategoriesController().setFoodCategoriesGUI(foodCategoriesGUI);
        mainController.getFoodCategoriesController().setButtonsFunctionality();

        // Create ModifierPopupGUI and link it to its required controller
        ModifierPopupGUI modifierPopupGUI = new ModifierPopupGUI(mainController);
        mainController.getFoodItemsController().setModifierPopupGUI(modifierPopupGUI);

        // Create FoodItemsGUI and set its layout
        FoodItemsGUI foodItemsGUI = new FoodItemsGUI(mainGui, mainController.getFoodItemsController());
        foodItemsGUI.setFoodItemsLayout(foodItemsGUI.initializeFoodItemsLayout());

        // Link together all the gui's layouts
        mainGui.linkTogetherLayouts(cartGUI, foodCategoriesGUI, foodItemsGUI);

        Scene scene = new Scene(mainGui.getRoot(), 1920, 1024);
        stage.setTitle("Restaurant App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}