package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.controllers.DataController;
import com.restaurant.restaurant_app.entities.Pizza;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Pizzas implements Map<String, Pizza> {
    static private Map<String, Pizza> pizzas = new HashMap();

    static {
        Pizza cheese = new Pizza("Cheese Pizza", 10.99);
        Pizza deluxe = new Pizza("Deluxe Pizza", 17.99);
        Pizza veggie = new Pizza("Veggie Pizza", 17.99);
        Pizza meat = new Pizza("Meat Pizza", 17.99);
        Pizza hawaiian = new Pizza("Hawaiian Pizza", 14.99);

        try {
            deluxe.addTopping(DataController.searchTopping("Pepperoni"));
            deluxe.addTopping(DataController.searchTopping("Sausage"));
            deluxe.addTopping(DataController.searchTopping("Beef"));
            deluxe.addTopping(DataController.searchTopping("Onions"));
            deluxe.addTopping(DataController.searchTopping("Mushrooms"));
            deluxe.addTopping(DataController.searchTopping("Black Olives"));
            deluxe.addTopping(DataController.searchTopping("Green Peppers"));

            veggie.addTopping(DataController.searchTopping("Onions"));
            veggie.addTopping(DataController.searchTopping("Mushrooms"));
            veggie.addTopping(DataController.searchTopping("Black Olives"));
            veggie.addTopping(DataController.searchTopping("Green Peppers"));
            veggie.addTopping(DataController.searchTopping("Spinach"));
            veggie.addTopping(DataController.searchTopping("Tomato"));

            meat.addTopping(DataController.searchTopping("Pepperoni"));
            meat.addTopping(DataController.searchTopping("Sausage"));
            meat.addTopping(DataController.searchTopping("Beef"));
            meat.addTopping(DataController.searchTopping("Ham"));
            meat.addTopping(DataController.searchTopping("Bacon"));

            hawaiian.addTopping(DataController.searchTopping("Ham"));

            hawaiian.addTopping(DataController.searchTopping("Pineapple"));
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        pizzas.put(cheese.getName(), cheese);
        pizzas.put(deluxe.getName(), deluxe);
        pizzas.put(veggie.getName(), veggie);
        pizzas.put(meat.getName(), meat);
        pizzas.put(hawaiian.getName(), hawaiian);
    }

    public static Map<String, Pizza> getPizzas() {
        return pizzas;
    }

    @Override
    public int size() {
        return pizzas.size();
    }

    @Override
    public boolean isEmpty() {
        return pizzas.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return pizzas.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return pizzas.containsValue(value);
    }

    @Override
    public Pizza get(Object key) {
        return pizzas.get(key);
    }

    @Override
    public Pizza put(String key, Pizza value) {
        return pizzas.put(key, value);
    }

    @Override
    public Pizza remove(Object key) {
        return pizzas.remove(key);
    }

    @Override
    public void putAll(Map m) {
        pizzas.putAll(m);
    }

    @Override
    public void clear() {
        pizzas.clear();
    }

    @Override
    public Set<String> keySet() {
        return pizzas.keySet();
    }

    @Override
    public Collection values() {
        return pizzas.values();
    }

    @Override
    public Set<Entry<String, Pizza>> entrySet() {
        return pizzas.entrySet();
    }

}
