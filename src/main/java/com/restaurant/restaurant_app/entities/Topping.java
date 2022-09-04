package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

import static com.restaurant.restaurant_app.enums.Enums.ToppingModifier.NORMAL;

public class Topping extends FoodItem{
    private Enums.ToppingModifier modifier;
    public Topping(String name) {
        super(name);
        setFoodType(Enums.FoodType.TOPPING);
        this.modifier = NORMAL;
        super.setToppings(null);
    }
    public Topping(String name, double price) {
        super(name, price);
        setFoodType(Enums.FoodType.TOPPING);
        this.modifier = NORMAL;
        super.setToppings(null);
    }

    public Enums.ToppingModifier getModifier() {
        return modifier;
    }

    public void setModifier(Enums.ToppingModifier modifier) {
        this.modifier = modifier;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Topping clone = (Topping) super.clone();
        clone.setModifier(modifier);
        return clone;
    }
}
