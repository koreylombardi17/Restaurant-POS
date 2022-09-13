package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.entities.ShoppingCart;
import com.restaurant.restaurant_app.ui.MainGUI;

import static com.restaurant.restaurant_app.enums.Enums.FoodType.PIZZA;

public class MainController {
    private MainGUI mainGUI;
    private DataController dataController;
    private CartController cartController;
    private FoodCategoriesController foodCategoriesController;
    private FoodItemsController foodItemsController;
    private ModifiersController modifiersController;
    private ShoppingCart cart;

    public MainController(ShoppingCart cart) {
        this.dataController = new DataController();
        this.cartController = new CartController();
        this.foodItemsController = new FoodItemsController();
        this.foodCategoriesController = new FoodCategoriesController(this.foodItemsController);
        this.modifiersController = new ModifiersController();
        this.cart = cart;
        linkControllers();
    }

    private void linkControllers() {
        this.dataController.setMainController(this);
        this.cartController.setMainController(this);
        this.foodCategoriesController.setMainController(this);
        this.foodItemsController.setMainController(this);
        this.modifiersController.setMainController(this);
    }

    public void setMainGUI(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

    public MainGUI getMainGUI() {
        return mainGUI;
    }

    public DataController getDataController() {
        return dataController;
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
