package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.service.Helper;
import com.restaurant.restaurant_app.ui.CartGUI;
import javafx.scene.control.ListCell;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO: Implement three cart buttons functionality
public class CartController {
    private MainController mainController;
    private CartGUI cartGUI;

    public CartController() {
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
                setOnMouseClicked(event -> {});
            }
        });
    }

    public void deleteFoodItemFromCart() {
        FoodItem selectedItem = this.cartGUI.getCartItemsListView().getSelectionModel().getSelectedItem();
        if (!selectedItem.getFoodType().equals(Enums.FoodType.TOPPING)){
            int index = this.cartGUI.getCartList().indexOf(selectedItem);
            this.mainController.getCart().removeFoodItem(selectedItem);
            this.cartGUI.getCartList().remove(index);
            while(((this.cartGUI.getCartList().size() > index))
                    && this.cartGUI.getCartList().get(index).getFoodType().equals(Enums.FoodType.TOPPING)) {
                this.cartGUI.getCartList().remove(index);
            }
            updateTotalLabel();
        }
    }

    public void repeatFoodItemFromCart() {
        FoodItem selectedItem = this.cartGUI.getCartItemsListView().getSelectionModel().getSelectedItem();
        if (!selectedItem.getFoodType().equals(Enums.FoodType.TOPPING)){
            addFoodItemToCartListView(selectedItem);
            updateTotalLabel();
        }
    }

    private void updateTotalLabel() {
        this.cartGUI.getTotalLabel().setText(Helper.formatTotal(mainController.getCart().getTotal()));
    }

    public void addFoodItemToCartListView(FoodItem foodItem) {
        this.cartGUI.getCartList().add(foodItem);
        addToppingsToCartListView(foodItem, Enums.ToppingType.FULL);
        addToppingsToCartListView(foodItem, Enums.ToppingType.FIRSTHALF);
        addToppingsToCartListView(foodItem, Enums.ToppingType.SECONDHALF);
        mainController.getCart().addFoodItem(foodItem);
        updateTotalLabel();
    }

    private void addToppingsToCartListView(FoodItem foodItem, Enums.ToppingType toppingType) {
        Stream<Topping> toppingStream = null;
        if (toppingType == Enums.ToppingType.FULL) {
            toppingStream = foodItem.getToppings().stream();
        } else if (toppingType == Enums.ToppingType.FIRSTHALF) {
            toppingStream = foodItem.getFirstHalfToppings().stream();
        } else if (toppingType == Enums.ToppingType.SECONDHALF) {
            toppingStream = foodItem.getSecondHalfToppings().stream();
        }
        List<Topping> toppingList = toppingStream.filter(topping -> !(topping.getModifier().equals(Enums.ToppingModifier.NORMAL)))
                .collect(Collectors.toList());
        this.cartGUI.getCartList().addAll(toppingList);
    }

    public void setCartGUI(CartGUI cartGUI) {
        this.cartGUI = cartGUI;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
