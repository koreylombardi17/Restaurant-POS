package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.FoodCategoriesController;
import com.restaurant.restaurant_app.controllers.FoodItemsController;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import static com.restaurant.restaurant_app.enums.Enums.FoodType.*;

public class FoodCategoriesGUI {
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

    public FoodCategoriesGUI() {
        initializeButtonsLayout();
    }

    private void initializeButtonsLayout() {
        this.appsBtn = new Button("APPS");
        this.wingsBtn = new Button("WINGS");
        this.saladsBtn = new Button("SALAD");
        this.pizzasBtn = new Button("PIZZAS");
        this.specialityPizzasBtn = new Button("SPECIALITY PIZZAS");
        this.subsBtn = new Button("SUBS");
        this.pastasBtn = new Button("PASTAS");
        this.sidesBtn = new Button("SIDES");
        this.dessertsBtn = new Button("DESSERTS");
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
