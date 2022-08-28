package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

public class SpecialityPizza extends FoodItem {
    public SpecialityPizza(String name) {
        super(name);
        setFoodType(Enums.FoodType.SPECIALITY_PIZZA);
    }

    public SpecialityPizza(String name, double price) {
        super(name, price);
        setFoodType(Enums.FoodType.SPECIALITY_PIZZA);
    }
}
