package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

public class Pizza extends FoodItem {
    public Pizza(String name) {
        super(name);
        this.setFoodType(Enums.FoodType.PIZZA);
    }

    public Pizza(String name, double price) {
        super(name, price);
        this.setFoodType(Enums.FoodType.PIZZA);
    }
}
