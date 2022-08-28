package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

public class Wing extends FoodItem {
    public Wing(String name) {
        super(name);
        setFoodType(Enums.FoodType.WINGS);
        super.setToppings(null);
    }

    public Wing(String name, double price) {
        super(name, price);
        setFoodType(Enums.FoodType.WINGS);
        super.setToppings(null);
    }
}
