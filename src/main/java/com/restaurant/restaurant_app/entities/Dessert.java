package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

public class Dessert extends FoodItem {
    public Dessert(String name) {
        super(name);
        this.setFoodType(Enums.FoodType.DESSERT);
    }

    public Dessert(String name, double price) {
        super(name, price);
        this.setFoodType(Enums.FoodType.DESSERT);
    }
}
