package com.restaurant.restaurant_app.entities;

import com.restaurant.restaurant_app.enums.Enums;

import static com.restaurant.restaurant_app.enums.Enums.ToppingModifier.NORMAL;

public class Topping implements Cloneable{
    private String name;
    private double price;
    private Enums.ToppingType toppingType;
    private Enums.ToppingModifier toppingModifier;
    public Topping(String name) {
        this.name = name;
        this.price = 0;
        this.toppingType = Enums.ToppingType.FULL;
        this.toppingModifier = NORMAL;
    }
    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
        this.toppingType = Enums.ToppingType.FULL;
        this.toppingModifier = NORMAL;
    }

    public Enums.ToppingModifier getToppingModifier() {
        return toppingModifier;
    }

    public void setToppingModifier(Enums.ToppingModifier toppingModifier) {
        this.toppingModifier = toppingModifier;
    }

    public Enums.ToppingType getToppingType() {
        return toppingType;
    }

    public void setToppingType(Enums.ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Topping clone = (Topping) super.clone();
        clone.setToppingModifier(toppingModifier);
        clone.setToppingType(toppingType);
        return clone;
    }
}
