package com.restaurant.restaurant_app.entities;


import com.restaurant.restaurant_app.enums.Enums;

import java.util.ArrayList;
import java.util.List;

public abstract class FoodItem implements Cloneable{
    private String name;
    private double price;
    private Enums.FoodType foodType;
    private List<Topping> toppings;

    public FoodItem(String name) {
        this.name = name;
        this.price = 0;
        this.toppings = new ArrayList<>();
    }

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.toppings = new ArrayList<>();
    }

    public void setFoodType(Enums.FoodType foodType) {
        this.foodType = foodType;
    }

    public Enums.FoodType getFoodType() {
        return foodType;
    }

    public Topping getTopping(Topping topping) {
        for(Topping tempTopping : this.toppings) {
            if(tempTopping.getName().contentEquals(topping.getName())) {
                return tempTopping;
            }
        } return null;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        if(this.toppings.contains(topping)) {
            this.toppings.remove(topping);
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else throw new IllegalArgumentException("Price must be greater or equal to 0");
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        FoodItem clone = (FoodItem) super.clone();
        if (toppings != null) {
            cloneToppings(clone);
        } else {
            clone.setToppings(null);
        }
        return clone;
    }

    private void cloneToppings(FoodItem clone) {
        List<Topping> toppingsList= new ArrayList<>();
        toppings.forEach(topping -> {
            try {
                toppingsList.add((Topping) topping.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        });
        clone.setToppings(toppingsList);
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", foodType=" + foodType +
                ", toppings=" + toppings +
                '}';
    }
}
