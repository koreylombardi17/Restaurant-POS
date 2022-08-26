package com.restaurant.restaurant_app.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<FoodItem> cart;
    private double total;

    public ShoppingCart() {
        this.total = 0;
        this.cart = new ArrayList<>();
    }

    public double getTotal() {
        return total;
    }

    public boolean addFoodItem(FoodItem foodItem) {
        this.total += foodItem.getPrice();
        return this.cart.add(foodItem);
    }

    public boolean removeFoodItem(FoodItem foodItem) {
        this.total -= foodItem.getPrice();
        return this.cart.remove(foodItem);
    }

    public List<FoodItem> getCart() {
        return this.cart;
    }
}
