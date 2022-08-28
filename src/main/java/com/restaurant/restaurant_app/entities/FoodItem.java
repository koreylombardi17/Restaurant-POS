package com.restaurant.restaurant_app.entities;


import com.restaurant.restaurant_app.enums.Enums;

import java.util.ArrayList;
import java.util.List;

public abstract class FoodItem {
    private String name;
    private double price;
    private Enums.FoodType foodType;
    private List<Topping> toppings;
    private List<Topping> firstHalfToppings;
    private List<Topping> secondHalfToppings;

    public FoodItem(String name) {
        this.name = name;
        this.price = 0;
        this.toppings = new ArrayList<>();
        this.firstHalfToppings = new ArrayList<>();
        this.secondHalfToppings = new ArrayList<>();
    }

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.toppings = new ArrayList<>();
        this.firstHalfToppings = new ArrayList<>();
        this.secondHalfToppings = new ArrayList<>();
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

    public List<Topping> getFirstHalfToppings() {
        return firstHalfToppings;
    }

    public List<Topping> getSecondHalfToppings() {
        return secondHalfToppings;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }
    public void addToppingFirstHalf(Topping topping) {
        this.firstHalfToppings.add(topping);
    }
    public void addToppingSecondHalf(Topping topping) {
        this.secondHalfToppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        if(this.toppings.contains(topping)) {
            this.toppings.remove(topping);
        }
    }

    public void removeToppingFirstHalf(Topping topping) {
        if(this.firstHalfToppings.contains(topping)) {
            this.firstHalfToppings.remove(topping);
        }
    }

    public void removeToppingSecondHalf(Topping topping) {
        if(this.secondHalfToppings.contains(topping)) {
            this.secondHalfToppings.remove(topping);
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}
