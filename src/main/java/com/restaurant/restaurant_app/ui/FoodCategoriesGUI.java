package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.FoodCategoriesController;
import com.restaurant.restaurant_app.controllers.FoodItemsController;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import static com.restaurant.restaurant_app.enums.Enums.FoodType.*;

public class FoodCategoriesGUI {
    private MainGUI mainGUI;
    private FoodItemsController foodItemsController;
    private FoodCategoriesController foodCategoriesController;

    private VBox foodCategoriesLayout;
    private Button appsBtn;
    private Button wingsBtn;
    private Button saladsBtn;
    private Button pizzasBtn;
    private Button specialityPizzasBtn;
    private Button subsBtn;
    private Button pastasBtn;
    private Button sidesBtn;
    private Button dessertsBtn;

    public FoodCategoriesGUI(MainGUI mainGUI, FoodItemsController foodItemsController, FoodCategoriesController foodCategoriesController) {
        this.mainGUI = mainGUI;
        this.foodItemsController = foodItemsController;
        this.foodCategoriesController = foodCategoriesController;
        initializeButtonsLayout();
    }

    private void initializeButtonsLayout() {
        this.appsBtn = new Button("APPS");
//        this.appsBtn.setOnAction(actionEvent -> this.foodItemsController.populateFoodItemsListView(APP));
        this.wingsBtn = new Button("WINGS");
//        this.wingsBtn.setOnAction(actionEvent -> this.foodItemsController.populateFoodItemsListView(WINGS));
        this.saladsBtn = new Button("SALAD");
//        this.saladsBtn.setOnAction(actionEvent -> this.foodItemsController.populateFoodItemsListView(SALAD));
        this.pizzasBtn = new Button("PIZZAS");
//        this.pizzasBtn.setOnAction(actionEvent -> this.foodItemsController.populateFoodItemsListView(PIZZA));
        this.specialityPizzasBtn = new Button("SPECIALITY PIZZAS");
//        this.specialityPizzasBtn.setOnAction(actionEvent -> this.foodItemsController.populateFoodItemsListView(SPECIALITY_PIZZA));
        this.subsBtn = new Button("SUBS");
//        this.subsBtn.setOnAction(actionEvent -> this.foodItemsController.populateFoodItemsListView(SUB));
        this.pastasBtn = new Button("PASTAS");
//        this.pastasBtn.setOnAction(actionEvent -> this.foodItemsController.populateFoodItemsListView(PASTA));
        this.sidesBtn = new Button("SIDES");
//        this.sidesBtn.setOnAction(actionEvent -> this.foodItemsController.populateFoodItemsListView(SIDE));
        this.dessertsBtn = new Button("DESSERTS");
//        this.dessertsBtn.setOnAction(actionEvent -> this.foodItemsController.populateFoodItemsListView(DESSERT));
        this.foodCategoriesLayout = new VBox(
                this.appsBtn, this.wingsBtn, this.saladsBtn,
                this.pizzasBtn, this.specialityPizzasBtn, this.subsBtn,
                this.pastasBtn, this.sidesBtn, this.dessertsBtn
        );
    }
    public VBox getFoodCategoriesLayout() {
        return foodCategoriesLayout;
    }

    public Button getAppsBtn() {
        return appsBtn;
    }

    public Button getWingsBtn() {
        return wingsBtn;
    }

    public Button getSaladsBtn() {
        return saladsBtn;
    }

    public Button getPizzasBtn() {
        return pizzasBtn;
    }

    public Button getSpecialityPizzasBtn() {
        return specialityPizzasBtn;
    }

    public Button getSubsBtn() {
        return subsBtn;
    }

    public Button getPastasBtn() {
        return pastasBtn;
    }

    public Button getSidesBtn() {
        return sidesBtn;
    }

    public Button getDessertsBtn() {
        return dessertsBtn;
    }
}
