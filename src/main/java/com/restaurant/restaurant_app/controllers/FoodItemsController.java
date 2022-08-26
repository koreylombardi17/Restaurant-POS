package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.data.DAO;
import com.restaurant.restaurant_app.entities.*;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.ui.FoodItemsGUI;
import com.restaurant.restaurant_app.ui.MainGUI;
import com.restaurant.restaurant_app.ui.ModifierPopupGUI;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

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
                            FoodItem foodItem = DAO.searchFoodItem(itemName);
                            new ModifierPopupGUI(mainController, foodItem);
                        });
                    }
                };
            }
        });
    }

    public void populateFoodItemsListView(Enums.FoodType foodType) {
        clearFoodItemsListView();
        switch (foodType) {
            case APP:
                for (Object object : DAO.appetizers.values()) {
                    Appetizer app = (Appetizer) object;
                    this.foodItemsGUI.getFoodItemsListView().getItems().add(app.getPrice() + "\t" + app.getName());
                }
                break;

            case WINGS:
                for (Object object : DAO.wings.values()) {
                    Wing wing = (Wing) object;
                    this.foodItemsGUI.getFoodItemsListView().getItems().add(wing.getPrice() + "\t" + wing.getName());
                }
                break;

            case SALAD:
                for (Object object : DAO.salads.values()) {
                    Salad salad = (Salad) object;
                    this.foodItemsGUI.getFoodItemsListView().getItems().add(salad.getPrice() + "\t" + salad.getName());
                }
                break;

            case PIZZA:
                for (Object object : DAO.pizzas.values()) {
                    Pizza pizza = (Pizza) object;
                    this.foodItemsGUI.getFoodItemsListView().getItems().add(pizza.getPrice() + "\t" + pizza.getName());
                }
                break;

            case SPECIALITY_PIZZA:
                for (Object object : DAO.specialityPizzas.values()) {
                    SpecialityPizza pizza = (SpecialityPizza) object;
                    this.foodItemsGUI.getFoodItemsListView().getItems().add(pizza.getPrice() + "\t" + pizza.getName());
                }
                break;

            case SUB:
                for (Object object : DAO.subs.values()) {
                    Sub sub = (Sub) object;
                    this.foodItemsGUI.getFoodItemsListView().getItems().add(sub.getPrice() + "\t" + sub.getName());
                }
                break;

            case PASTA:
                for (Object object : DAO.pastas.values()) {
                    Pasta pasta = (Pasta) object;
                    this.foodItemsGUI.getFoodItemsListView().getItems().add(pasta.getPrice() + "\t" + pasta.getName());
                }
                break;

            case SIDE:
                for (Object object : DAO.sides.values()) {
                    Side side = (Side) object;
                    this.foodItemsGUI.getFoodItemsListView().getItems().add(side.getPrice() + "\t" + side.getName());
                }
                break;

            case DESSERT:
                for (Object object : DAO.desserts.values()) {
                    Dessert dessert = (Dessert) object;
                    this.foodItemsGUI.getFoodItemsListView().getItems().add(dessert.getPrice() + "\t" + dessert.getName());
                }
                break;
        }
        if (this.foodItemsGUI.getFoodItemsLayout() != null) {
            this.foodItemsGUI.getFoodItemsLayout().getChildren().clear();
            this.foodItemsGUI.getFoodItemsLayout().getChildren().add(this.foodItemsGUI.getFoodItemsListView());
        }
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
