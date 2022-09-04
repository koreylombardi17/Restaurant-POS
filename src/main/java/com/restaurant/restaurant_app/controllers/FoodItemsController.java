package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.data.DAO;
import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.ui.FoodItemsGUI;
import com.restaurant.restaurant_app.ui.MainGUI;
import com.restaurant.restaurant_app.ui.ModifierPopupGUI;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.Collection;

public class FoodItemsController {
    private MainController mainController;
    private MainGUI mainGUI;
    private FoodItemsGUI foodItemsGUI;

    public FoodItemsController(MainController mainController) {
        this.mainController = mainController;
        this.mainGUI = null;
        this.foodItemsGUI = null;
    }

    public void initializeFoodItemCells() {
        this.foodItemsGUI.getFoodItemsListView().setCellFactory(new Callback<>() {
            @Override
            public ListCell<String> call(ListView<String> p) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String t, boolean bln) {
                        super.updateItem(t, bln);
                        setText(t);
                        setOnMouseClicked(event -> {
                            String itemName = getText();
                            FoodItem foodItem = null;
                            try {
                                foodItem = mainController.getDataController().searchFoodItem(itemName);
                            } catch (CloneNotSupportedException e) {
                                throw new RuntimeException(e);
                            }
                            new ModifierPopupGUI(mainController, foodItem);
                        });
                    }
                };
            }
        });
    }

    public void populateFoodItemsListView(Enums.FoodType foodType) {
        clearFoodItemsListView();
        populateFoodItemsListViewByCategory(foodType);
        if (this.foodItemsGUI.getFoodItemsLayout() != null) {
            this.foodItemsGUI.getFoodItemsLayout().getChildren().clear();
            this.foodItemsGUI.getFoodItemsLayout().getChildren().add(this.foodItemsGUI.getFoodItemsListView());
        }
    }

    private void populateFoodItemsListViewByCategory(Enums.FoodType foodType) {
        Collection<? extends FoodItem> foodItemsByCategory = DAO.getFoodItemsByCategory(foodType);
        foodItemsByCategory.forEach(foodItem -> {
            this.foodItemsGUI.getFoodItemsListView().getItems().add(foodItem.getPrice() + "\t" + foodItem.getName());
        });
    }

    private void clearFoodItemsListView() {
        if (!this.foodItemsGUI.getFoodItemsListView().getItems().isEmpty()) {
            this.foodItemsGUI.getFoodItemsListView().getItems().clear();
            this.foodItemsGUI.getFoodItemsLayout().getChildren().remove(this.foodItemsGUI.getFoodItemsListView());
        }
    }

    public void setMainGUI(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

    public void setFoodItemsGUI(FoodItemsGUI foodItemsGUI) {
        this.foodItemsGUI = foodItemsGUI;
    }
}
