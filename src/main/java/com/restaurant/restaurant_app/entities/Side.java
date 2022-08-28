package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

public class Side extends FoodItem {
    public Side(String name) {
        super(name);
        setFoodType(Enums.FoodType.SIDE);
    }

    public Side(String name, double price) {
        super(name, price);
        setFoodType(Enums.FoodType.SIDE);
    }
}
