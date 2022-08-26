package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.ui.FoodCategoriesGUI;

import static com.restaurant.restaurant_app.enums.Enums.FoodType.*;

public class FoodCategoriesController {
    private MainController mainController;
    private FoodItemsController foodItemsController;
    private FoodCategoriesGUI foodCategoriesGUI;

    public FoodCategoriesController(MainController mainController) {
        this. mainController = mainController;
        this.foodItemsController = mainController.getFoodItemsController();
        this.foodCategoriesGUI = null;
    }

    public void setFoodCategoriesGUI(FoodCategoriesGUI foodCategoriesGUI) {
        this.foodCategoriesGUI = foodCategoriesGUI;
    }

    public void setButtonsFunctionality(){
        foodCategoriesGUI.getAppsBtn().setOnAction(actionEvent -> foodItemsController.populateFoodItemsListView(APP));
        foodCategoriesGUI.getWingsBtn().setOnAction(actionEvent -> foodItemsController.populateFoodItemsListView(WINGS));
        foodCategoriesGUI.getSaladsBtn().setOnAction(actionEvent -> foodItemsController.populateFoodItemsListView(SALAD));
        foodCategoriesGUI.getPizzasBtn().setOnAction(actionEvent -> foodItemsController.populateFoodItemsListView(PIZZA));
        foodCategoriesGUI.getSpecialityPizzasBtn().setOnAction(actionEvent -> foodItemsController.populateFoodItemsListView(SPECIALITY_PIZZA));
        foodCategoriesGUI.getSubsBtn().setOnAction(actionEvent -> foodItemsController.populateFoodItemsListView(SUB));
        foodCategoriesGUI.getPastasBtn().setOnAction(actionEvent -> foodItemsController.populateFoodItemsListView(PASTA));
        foodCategoriesGUI.getSidesBtn().setOnAction(actionEvent -> foodItemsController.populateFoodItemsListView(SIDE));
        foodCategoriesGUI.getDessertsBtn().setOnAction(actionEvent -> foodItemsController.populateFoodItemsListView(DESSERT));

    }
}
