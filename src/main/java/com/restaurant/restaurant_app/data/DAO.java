package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.service.Helper;

public class DAO {
    public static Toppings toppings = new Toppings();
    public static Appetizers appetizers = new Appetizers();
    public static Wings wings = new Wings();
    public static Salads salads = new Salads();
    public static Pizzas pizzas = new Pizzas();
    public static SpecialityPizzas specialityPizzas = new SpecialityPizzas();
    public static Subs subs = new Subs();
    public static Pastas pastas = new Pastas();
    public static Sides sides = new Sides();
    public static Desserts desserts = new Desserts();

    public static FoodItem searchFoodItem(String listItemsText) {
        String foodItemsName = Helper.removeLeadingTabs(listItemsText);
        if(appetizers.containsKey(foodItemsName)) {
            return appetizers.get(foodItemsName);
        } else if(wings.containsKey(foodItemsName)) {
            return wings.get(foodItemsName);
        } else if(salads.containsKey(foodItemsName)) {
            return salads.get(foodItemsName);
        } else if(pizzas.containsKey(foodItemsName)) {
            return pizzas.get(foodItemsName);
        } else if(specialityPizzas.containsKey(foodItemsName)) {
            return specialityPizzas.get(foodItemsName);
        } else if(subs.containsKey(foodItemsName)) {
            return subs.get(foodItemsName);
        } else if(pastas.containsKey(foodItemsName)) {
            return pastas.get(foodItemsName);
        } else if(sides.containsKey(foodItemsName)) {
            return sides.get(foodItemsName);
        } else if(desserts.containsKey(foodItemsName)) {
            return desserts.get(foodItemsName);
        } else return null;
    }

    public static Topping searchTopping(String toppingsName) {
        if(toppings.containsKey(toppingsName)) {
            return toppings.get(toppingsName);
        } else return null;
    }
}
