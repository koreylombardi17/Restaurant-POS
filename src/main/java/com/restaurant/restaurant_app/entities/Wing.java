package com.restaurant.restaurant_app.entities;

public class Wing extends FoodItem {
    public Wing(String name) {
        super(name);
        super.setToppings(null);
    }

    public Wing(String name, double price) {
        super(name, price);
        super.setToppings(null);
    }
}
