package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.FoodItemsController;
import com.restaurant.restaurant_app.controllers.MainController;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import static com.restaurant.restaurant_app.enums.Enums.FoodType.PIZZA;

public class FoodItemsGUI {
    private FoodItemsController foodItemsController;
    private MainGUI mainGUI;
    private VBox foodItemsLayout;
    private ListView<String> foodItemsListView;

    public FoodItemsGUI(MainGUI mainGUI, FoodItemsController foodItemsController) {
        this.mainGUI = mainGUI;
        this.foodItemsController = foodItemsController;
        this.foodItemsController.setFoodItemsGUI(this);
        this.foodItemsListView = new ListView<>();
        this.foodItemsLayout = initializeFoodItemsLayout();
        this.foodItemsController.populateFoodItemsListView(PIZZA);
    }

    public VBox initializeFoodItemsLayout() {
        this.foodItemsListView.setPrefHeight(1024);
        this.foodItemsController.initializeFoodItemCells();
        return new VBox(this.foodItemsListView);
    }

    public void setFoodItemsLayout(VBox foodItemsLayout) {
        this.foodItemsLayout = foodItemsLayout;
    }

    public VBox getFoodItemsLayout() {
        return foodItemsLayout;
    }

    public ListView<String> getFoodItemsListView() {
        return foodItemsListView;
    }
}
