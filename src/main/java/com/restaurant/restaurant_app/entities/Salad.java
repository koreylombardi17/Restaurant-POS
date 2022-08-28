package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

public class Salad extends FoodItem {
    public Salad(String name) {
        super(name);
        setFoodType(Enums.FoodType.SALAD);
    }

    public Salad(String name, double price) {
        super(name, price);
        setFoodType(Enums.FoodType.SALAD);
    }
}
