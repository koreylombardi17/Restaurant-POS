package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.Topping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Toppings implements Map<String, Topping> {
    static private Map<String, Topping> toppings = new HashMap();

    static {
        Topping pepperoni = new Topping("Pepperoni");
        Topping sausage = new Topping("Sausage");
        Topping beef = new Topping("Beef");
        Topping ham = new Topping("Ham");
        Topping bacon = new Topping("Bacon");
        Topping onions = new Topping("Onions");
        Topping mushrooms = new Topping("Mushrooms");
        Topping greenPeppers = new Topping("Green Peppers");
        Topping blackOlives = new Topping("Black Olives");
        Topping spinach = new Topping("Spinach");
        Topping tomato = new Topping("Tomato");
        Topping jalapeno = new Topping("Jalapeno Peppers");
        Topping pineapple = new Topping("Pineapple");
        toppings.put(pepperoni.getName(), pepperoni);
        toppings.put(sausage.getName(), sausage);
        toppings.put(beef.getName(), beef);
        toppings.put(ham.getName(), ham);
        toppings.put(bacon.getName(), bacon);
        toppings.put(onions.getName(), onions);
        toppings.put(mushrooms.getName(), mushrooms);
        toppings.put(greenPeppers.getName(), greenPeppers);
        toppings.put(blackOlives.getName(), blackOlives);
        toppings.put(spinach.getName(), spinach);
        toppings.put(tomato.getName(), tomato);
        toppings.put(jalapeno.getName(), jalapeno);
        toppings.put(pineapple.getName(), pineapple);
    }

    public static Map<String, Topping> getToppings() {
        return toppings;
    }

    @Override
    public int size() {
        return toppings.size();
    }

    @Override
    public boolean isEmpty() {
        return toppings.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return toppings.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return toppings.containsValue(value);
    }

    @Override
    public Topping get(Object key) {
        return toppings.get(key);
    }

    @Override
    public Topping put(String key, Topping value) {
        return toppings.put(key, value);
    }

    @Override
    public Topping remove(Object key) {
        return toppings.remove(key);
    }

    @Override
    public void putAll(Map m) {
        toppings.putAll(m);
    }

    @Override
    public void clear() {
        toppings.clear();
    }

    @Override
    public Set<String> keySet() {
        return toppings.keySet();
    }

    @Override
    public Collection values() {
        return toppings.values();
    }

    @Override
    public Set<Entry<String, Topping>> entrySet() {
        return toppings.entrySet();
    }
}
