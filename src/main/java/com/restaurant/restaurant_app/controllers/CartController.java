package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.service.Helper;
import com.restaurant.restaurant_app.ui.CartGUI;
import com.restaurant.restaurant_app.ui.listviews.CartItemsListView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO: Implement three cart buttons functionality
// TODO: Display first half and second half. First and second half
// TODO: is being added correctly, just not displayed correctly
public class CartController {
    private MainController mainController;
    private CartGUI cartGUI;
    private CartItemsListView cartItemsListView;

    public CartController() {
        this.cartGUI = null;
    }

    //    public void deleteFoodItemFromCart() {
//        FoodItem selectedItem = this.cartGUI.getCartItemsListView().getSelectionModel().getSelectedItem();
//        if (!selectedItem.getFoodType().equals(Enums.FoodType.TOPPING)){
//            int index = this.cartGUI.getCartList().indexOf(selectedItem);
//            this.mainController.getCart().removeFoodItem(selectedItem);
//            this.cartGUI.getCartList().remove(index);
//            while(((this.cartGUI.getCartList().size() > index))
//                    && this.cartGUI.getCartList().get(index).getFoodType().equals(Enums.FoodType.TOPPING)) {
//                this.cartGUI.getCartList().remove(index);
//            }
//            updateTotalLabel();
//        }
//    }
//
//    public void repeatFoodItemFromCart() {
//        FoodItem selectedItem = this.cartGUI.getCartItemsListView().getSelectionModel().getSelectedItem();
//        if (!selectedItem.getFoodType().equals(Enums.FoodType.TOPPING)){
//            addFoodItemToCartListView(selectedItem);
//            updateTotalLabel();
//        }
//    }

    private void updateTotalLabel() {
        this.cartGUI.getTotalLabel().setText(Helper.formatTotal(mainController.getCart().getTotal()));
    }

    public void addFoodItemToCartListView(FoodItem foodItem) {
        this.cartItemsListView.getCartList().add(foodItem);
        addToppingsToCartListView(foodItem);
        mainController.getCart().addFoodItem(foodItem);
        updateTotalLabel();
    }

    private void addToppingsToCartListView(FoodItem foodItem) {
        Stream<Topping> toppingStream = foodItem.getToppings().stream();
        List<Topping> toppingList = toppingStream.filter(topping -> !(topping.getToppingModifier().equals(Enums.ToppingModifier.NORMAL)))
                .collect(Collectors.toList());
        cartItemsListView.getCartList().addAll(toppingList);
    }

    public void setCartItemsListView(CartItemsListView cartItemsListView) {
        this.cartItemsListView = cartItemsListView;
    }

    public void setCartGUI(CartGUI cartGUI) {
        this.cartGUI = cartGUI;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
