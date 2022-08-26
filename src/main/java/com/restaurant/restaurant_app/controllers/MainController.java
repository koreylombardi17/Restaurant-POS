package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.entities.ShoppingCart;
import com.restaurant.restaurant_app.ui.MainGUI;

import static com.restaurant.restaurant_app.enums.Enums.FoodType.PIZZA;

public class MainController {
    private MainGUI mainGUI;
    private CartController cartController;
    private FoodCategoriesController foodCategoriesController;
    private FoodItemsController foodItemsController;
    private ModifiersController modifiersController;
    private ShoppingCart cart;

    public MainController() {
        this.mainGUI = null;
        this.cartController = new CartController(this);
        this.foodItemsController = new FoodItemsController(this);
        this.foodCategoriesController = new FoodCategoriesController(this);
        this.modifiersController = new ModifiersController(this);
        this.cart = new ShoppingCart();
    }

    public void setMainGUI(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

    public MainGUI getMainGUI() {
        return mainGUI;
    }

    public CartController getCartController() {
        return cartController;
    }

    public FoodCategoriesController getFoodCategoriesController() {
        return foodCategoriesController;
    }

    public FoodItemsController getFoodItemsController() {
        return foodItemsController;
    }

    public ModifiersController getModifiersController() {
        return modifiersController;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
