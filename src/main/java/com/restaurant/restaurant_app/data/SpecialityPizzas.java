package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.SpecialityPizza;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SpecialityPizzas implements Map<String, SpecialityPizza> {
    static private Map<String, SpecialityPizza> pizzas = new HashMap();

    static {
        SpecialityPizza alfredoChickenPizza = new SpecialityPizza("Alfredo Chicken Pizza", 19.99);
        SpecialityPizza buffaloChickenPizza = new SpecialityPizza("Buffalo Chicken Pizza", 19.99);
        SpecialityPizza whitePizza = new SpecialityPizza("White Pizza", 19.99);
        SpecialityPizza pestoChickenPizza = new SpecialityPizza("Pesto Chicken Pizza", 19.99);
        SpecialityPizza phillyCheeseSteakPizza = new SpecialityPizza("Philly Cheese Steak Pizza", 19.99);
        SpecialityPizza bltPizza = new SpecialityPizza("BLT Pizza", 19.99);
        pizzas.put(alfredoChickenPizza.getName(), alfredoChickenPizza);
        pizzas.put(buffaloChickenPizza.getName(), buffaloChickenPizza);
        pizzas.put(whitePizza.getName(), whitePizza);
        pizzas.put(pestoChickenPizza.getName(), pestoChickenPizza);
        pizzas.put(phillyCheeseSteakPizza.getName(), phillyCheeseSteakPizza);
        pizzas.put(bltPizza.getName(), bltPizza);
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
    public SpecialityPizza get(Object key) {
        return pizzas.get(key);
    }

    @Override
    public SpecialityPizza put(String key, SpecialityPizza value) {
        return pizzas.put(key, value);
    }

    @Override
    public SpecialityPizza remove(Object key) {
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
    public Set<Entry<String, SpecialityPizza>> entrySet() {
        return pizzas.entrySet();
    }

}
