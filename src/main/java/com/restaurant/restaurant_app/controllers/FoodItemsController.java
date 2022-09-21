package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.data.DAO;
import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.ui.FoodItemsGUI;
import com.restaurant.restaurant_app.ui.MainGUI;
import com.restaurant.restaurant_app.ui.ModifierPopupGUI;
import com.restaurant.restaurant_app.ui.listviews.FoodItemsListView;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.Collection;

public class FoodItemsController {
    private MainController mainController;
    private MainGUI mainGUI;
    private ModifierPopupGUI modifierPopupGUI;
    private FoodItemsGUI foodItemsGUI;
    private FoodItemsListView foodItemsListView;


    public FoodItemsController() {
        this.mainGUI = null;
        this.foodItemsGUI = null;
    }

    public void populateFoodItemsListView(Enums.FoodType foodType) {
        clearFoodItemsListView();
        populateFoodItemsListViewByCategory(foodType);
        if (this.foodItemsGUI.getFoodItemsLayout() != null) {
            this.foodItemsGUI.getFoodItemsLayout().getChildren().clear();
            this.foodItemsGUI.getFoodItemsLayout().getChildren().add(this.foodItemsListView.getFoodItemsListView());
        }
    }

    private void populateFoodItemsListViewByCategory(Enums.FoodType foodType) {
        Collection<? extends FoodItem> foodItemsByCategory = DataController.getFoodItemsByCategory(foodType);
        foodItemsByCategory.forEach(foodItem -> {
            this.foodItemsListView.getFoodItemsListView().getItems().add(foodItem.getPrice() + "\t" + foodItem.getName());
        });
    }

    private void clearFoodItemsListView() {
        if (!this.foodItemsListView.getFoodItemsListView().getItems().isEmpty()) {
            this.foodItemsListView.getFoodItemsListView().getItems().clear();
            this.foodItemsGUI.getFoodItemsLayout().getChildren().remove(this.foodItemsListView.getFoodItemsListView());
        }
    }

    public void setFoodItemsListView(FoodItemsListView foodItemsListView) {
        this.foodItemsListView = foodItemsListView;
    }

    public void setMainGUI(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

    public void setFoodItemsGUI(FoodItemsGUI foodItemsGUI) {
        this.foodItemsGUI = foodItemsGUI;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setModifierPopupGUI(ModifierPopupGUI modifierPopupGUI) {
        this.modifierPopupGUI = modifierPopupGUI;
    }
}
