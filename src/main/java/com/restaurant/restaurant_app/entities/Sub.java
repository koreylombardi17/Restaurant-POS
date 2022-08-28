package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

public class Sub extends FoodItem {
    public Sub(String name) {
        super(name);
        setFoodType(Enums.FoodType.SUB);
    }

    public Sub(String name, double price) {
        super(name, price);
        setFoodType(Enums.FoodType.SUB);
    }
}
