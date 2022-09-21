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
        // Shopping Cart Object
        ShoppingCart cart = new ShoppingCart();

        // Main controller object that contains all controllers
        MainController mainController = new MainController(cart);

        // App's main gui that contains sub gui's
        MainGUI mainGui = new MainGUI(stage, mainController);
        // Link mainController with mainGui
        mainController.getFoodItemsController().setMainGUI(mainGui);

        // Create cartGUI and link it to cartController
        CartGUI cartGUI = new CartGUI(mainController.getCartController());
        mainController.getCartController().setCartGUI(cartGUI);

        // Create cartItemsListView, link to cartController, and initialize its data
        CartItemsListView cartItemsListView = new CartItemsListView();
        mainController.getCartController().setCartItemsListView(cartItemsListView);
        cartItemsListView.initializeListViewCells();

        // Initialize cartGUI's layout and set its cartItemsListView
        // cartItemsListView (above code) must run before this line can be executed.
        cartGUI.setCartItemsListView(cartItemsListView);
        cartGUI.initializeCartGUILayout();

        // Create foodCategoriesGUI, link it to foodCategoriesController, and set button's functionality
        FoodCategoriesGUI foodCategoriesGUI = new FoodCategoriesGUI();
        mainController.getFoodCategoriesController().setFoodCategoriesGUI(foodCategoriesGUI);
        mainController.getFoodCategoriesController().setButtonsFunctionality();

        // Create modifierPopupGUI and link it to foodItemsController
        ModifierPopupGUI modifierPopupGUI = new ModifierPopupGUI(mainController);
        mainController.getFoodItemsController().setModifierPopupGUI(modifierPopupGUI);

        // Create foodItemsListView, link to modifierGUI, and initialize its data
        ModifiersItemsListView modifiersItemsListView = new ModifiersItemsListView(modifierPopupGUI, mainController.getModifiersController());
        modifierPopupGUI.setModifiersItemsListView(modifiersItemsListView);
        modifiersItemsListView.initializeListViewCells();

        // Initialize modifierPopupGUI's stage, buttons, layout, and scene.
        // modifiersItemsListView (above code) must run before this line can be executed.
        modifierPopupGUI.initializeModifierPopupGUI();

        // Create foodItemsGUI and set its layout
        FoodItemsGUI foodItemsGUI = new FoodItemsGUI(mainController.getFoodItemsController());

        // Create foodItemsListView and initialize its data
        FoodItemsListView foodItemsListView = new FoodItemsListView(modifierPopupGUI, foodItemsGUI, mainController.getDataController());
        foodItemsListView.initializeListViewCells();

        // Link foodItemsListView to foodItemsGUI and foodItemsController, then set layout in foodItemsGUI
        foodItemsGUI.setFoodItemsListView(foodItemsListView);
        mainController.getFoodItemsController().setFoodItemsListView(foodItemsListView);
        foodItemsGUI.setFoodItemsLayout(foodItemsGUI.initializeFoodItemsLayout());

        // setFoodItemsListView (above code) must run before this line can be executed.
        foodItemsGUI.initializeFoodItemsGui();

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