package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.Pizza;
import com.restaurant.restaurant_app.entities.Topping;

import java.util.*;

public class Pizzas implements Map<String, Pizza> {
    static private Map<String, Pizza> pizzas = new HashMap();

    static {
        Pizza cheese = new Pizza("Cheese Pizza", 10.99);
        Pizza deluxe = new Pizza("Deluxe Pizza", 17.99);
        Pizza veggie = new Pizza("Veggie Pizza", 17.99);
        Pizza meat = new Pizza("Meat Pizza", 17.99);
        Pizza hawaiian = new Pizza("Hawaiian Pizza", 14.99);

        try {
            deluxe.addTopping((Topping) DAO.toppings.get("Pepperoni").clone());
            deluxe.addTopping((Topping) DAO.toppings.get("Sausage").clone());
            deluxe.addTopping((Topping) DAO.toppings.get("Beef").clone());
            deluxe.addTopping((Topping) DAO.toppings.get("Onions").clone());
            deluxe.addTopping((Topping) DAO.toppings.get("Mushrooms").clone());
            deluxe.addTopping((Topping) DAO.toppings.get("Black Olives").clone());
            deluxe.addTopping((Topping) DAO.toppings.get("Green Peppers").clone());

            veggie.addTopping((Topping) DAO.toppings.get("Onions").clone());
            veggie.addTopping((Topping) DAO.toppings.get("Mushrooms").clone());
            veggie.addTopping((Topping) DAO.toppings.get("Black Olives").clone());
            veggie.addTopping((Topping) DAO.toppings.get("Green Peppers").clone());
            veggie.addTopping((Topping) DAO.toppings.get("Spinach").clone());
            veggie.addTopping((Topping) DAO.toppings.get("Tomato").clone());

            meat.addTopping((Topping) DAO.toppings.get("Pepperoni").clone());
            meat.addTopping((Topping) DAO.toppings.get("Sausage").clone());
            meat.addTopping((Topping) DAO.toppings.get("Beef").clone());
            meat.addTopping((Topping) DAO.toppings.get("Ham").clone());
            meat.addTopping((Topping) DAO.toppings.get("Bacon").clone());

            hawaiian.addTopping((Topping) DAO.toppings.get("Ham").clone());
            hawaiian.addTopping((Topping) DAO.toppings.get("Pineapple").clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        pizzas.put(cheese.getName(), cheese);
        pizzas.put(deluxe.getName(), deluxe);
        pizzas.put(veggie.getName(), veggie);
        pizzas.put(meat.getName(), meat);
        pizzas.put(hawaiian.getName(), hawaiian);
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
