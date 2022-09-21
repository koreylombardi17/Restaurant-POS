package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.FoodItemsController;
import com.restaurant.restaurant_app.ui.listviews.FoodItemsListView;
import javafx.scene.layout.VBox;

import static com.restaurant.restaurant_app.enums.Enums.FoodType.PIZZA;

public class FoodItemsGUI {
    private FoodItemsController foodItemsController;
    private FoodItemsListView foodItemsListView;
    private VBox foodItemsLayout;

    public FoodItemsGUI(FoodItemsController foodItemsController) {
        this.foodItemsController = foodItemsController;
        this.foodItemsController.setFoodItemsGUI(this);
    }

    public void initializeFoodItemsGui() {
        this.foodItemsLayout = initializeFoodItemsLayout();
        this.foodItemsController.populateFoodItemsListView(PIZZA);
    }

    public VBox initializeFoodItemsLayout() {
        this.foodItemsListView.getFoodItemsListView().setPrefHeight(1024);
        return new VBox(this.foodItemsListView.getFoodItemsListView());
    }

    public void setFoodItemsLayout(VBox foodItemsLayout) {
        this.foodItemsLayout = foodItemsLayout;
    }

    public void setFoodItemsListView(FoodItemsListView foodItemsListView) {
        this.foodItemsListView = foodItemsListView;
    }

    public VBox getFoodItemsLayout() {
        return foodItemsLayout;
    }
}
