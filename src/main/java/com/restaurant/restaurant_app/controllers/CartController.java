package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.service.Helper;
import com.restaurant.restaurant_app.ui.CartGUI;
import javafx.scene.control.ListCell;

// TODO: Implement three cart buttons functionality
public class CartController {
    private final MainController mainController;
    private CartGUI cartGUI;

    public CartController(MainController mainController) {
        this.mainController = mainController;
        this.cartGUI = null;
    }

    public void initializeCartItemCells() {
        this.cartGUI.getCartItemsListView().setCellFactory(param -> new ListCell<FoodItem>() {
            @Override
            protected void updateItem(FoodItem foodItem, boolean empty){
                super.updateItem(foodItem, empty);
                if(empty || foodItem == null || foodItem.getName() == null){
                    setText("");
                }
                else{
                    // TODO: Display first half and second half. First and second half
                    // TODO: is being added correctly, just not displayed correctly
                    if (foodItem.getClass() == Topping.class) {
                        setText("\t" + ((Topping) foodItem).getModifier() + " " + foodItem.getName());
                    } else {
                        setText(foodItem.getName() + "\t" + foodItem.getPrice());
                    }
                }
                setOnMouseClicked(event -> {
                    System.out.println("clicked");
                });
            }
        });
    }

    private void updateTotalLabel() {
        this.cartGUI.getTotalLabel().setText(Helper.formatTotal(mainController.getCart().getTotal()));
    }

    public void addFoodItemToCartListView(FoodItem foodItem) {
        this.cartGUI.getCartList().add(foodItem);
        for (Topping topping : foodItem.getToppings()) {
            if (topping.getModifier() != Enums.ToppingModifier.NORMAL) {
                this.cartGUI.getCartList().add(topping);
                System.out.println("Full Topping = " + topping);
            }
        }
        for (Topping topping : foodItem.getFirstHalfToppings()) {
            if (topping.getModifier() != Enums.ToppingModifier.NORMAL) {
                this.cartGUI.getCartList().add(topping);
                System.out.println("First half Topping = " + topping);
            }
        }
        for (Topping topping : foodItem.getSecondHalfToppings()) {
            if (topping.getModifier() != Enums.ToppingModifier.NORMAL) {
                this.cartGUI.getCartList().add(topping);
                System.out.println("Second Half Topping = " + topping);
            }
        }
        mainController.getCart().addFoodItem(foodItem);
        updateTotalLabel();
    }

    public void setCartGUI(CartGUI cartGUI) {
        this.cartGUI = cartGUI;
    }

    public CartGUI getCartGUI() {
        return cartGUI;
    }
}
