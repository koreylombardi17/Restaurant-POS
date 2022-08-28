package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

public class Pasta extends FoodItem {
    public Pasta(String name) {
        super(name);
        this.setFoodType(Enums.FoodType.PASTA);
    }

    public Pasta(String name, double price) {
        super(name, price);
        this.setFoodType(Enums.FoodType.PASTA);
    }
}
