package com.restaurant.restaurant_app.entities;


import com.restaurant.restaurant_app.enums.Enums;

import java.util.ArrayList;
import java.util.List;

public abstract class FoodItem implements Cloneable{
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

    public void setFirstHalfToppings(List<Topping> firstHalfToppings) {
        this.firstHalfToppings = firstHalfToppings;
    }

    public void setSecondHalfToppings(List<Topping> secondHalfToppings) {
        this.secondHalfToppings = secondHalfToppings;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        FoodItem clone = (FoodItem) super.clone();
        if (toppings != null) {
            cloneToppings(clone);
            cloneFirstHalfToppings(clone);
            cloneSecondHalfToppings(clone);
        } else {
            clone.setToppings(null);
            clone.setFirstHalfToppings(null);
            clone.setSecondHalfToppings(null);
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

    private void cloneFirstHalfToppings(FoodItem clone) {
        List<Topping> toppingsList= new ArrayList<>();
        firstHalfToppings.forEach(topping -> {
            try {
                toppingsList.add((Topping) topping.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        });
        clone.setFirstHalfToppings(toppingsList);
    }

    private void cloneSecondHalfToppings(FoodItem clone) {
        List<Topping> toppingsList= new ArrayList<>();
        secondHalfToppings.forEach(topping -> {
            try {
                toppingsList.add((Topping) topping.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        });
        clone.setSecondHalfToppings(toppingsList);
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", foodType=" + foodType +
                ", toppings=" + toppings +
                ", firstHalfToppings=" + firstHalfToppings +
                ", secondHalfToppings=" + secondHalfToppings +
                '}';
    }
}
