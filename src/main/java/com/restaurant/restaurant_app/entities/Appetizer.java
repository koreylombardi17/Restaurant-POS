package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

public class Appetizer extends FoodItem {
    public Appetizer(String name) {
        super(name);
        setFoodType(Enums.FoodType.APP);
    }

    public Appetizer(String name, double price) {
        super(name, price);
        setFoodType(Enums.FoodType.APP);
    }
}
