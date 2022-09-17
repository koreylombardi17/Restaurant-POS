package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.enums.Enums;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DAO {
    public static final Toppings toppings = new Toppings();
    public static final Appetizers appetizers = new Appetizers();
    public static final Wings wings = new Wings();
    public static final Salads salads = new Salads();
    public static final Pizzas pizzas = new Pizzas();
    public static final SpecialityPizzas specialityPizzas = new SpecialityPizzas();
    public static final Subs subs = new Subs();
    public static final Pastas pastas = new Pastas();
    public static final Sides sides = new Sides();
    public static final Desserts desserts = new Desserts();
    public static final List<Map<String, ? extends FoodItem>> allFoodItems = new ArrayList<>(
            List.of(toppings.getToppings(), appetizers.getApps(), wings.getWings(),
                    salads.getSalads(), pizzas.getPizzas(), specialityPizzas.getPizzas(),
                    subs.getSubs(), pastas.getPastas(), sides.getSides(), desserts.getDesserts()));
}
