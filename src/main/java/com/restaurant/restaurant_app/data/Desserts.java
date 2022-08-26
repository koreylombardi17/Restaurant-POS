package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.Dessert;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Desserts implements Map<String, Dessert> {
    static private Map<String, Dessert> desserts = new HashMap();

    static {
        Dessert cheeseCake = new Dessert("Cheese Cake", 6.99);
        Dessert chocolateCake = new Dessert("Chocolate Cake", 6.99);
        Dessert zeppolis = new Dessert("Zeppolis", 5.99);
        Dessert cinnabees = new Dessert("Cinnabees", 5.99);
        desserts.put(cheeseCake.getName(), cheeseCake);
        desserts.put(chocolateCake.getName(), chocolateCake);
        desserts.put(zeppolis.getName(), zeppolis);
        desserts.put(cinnabees.getName(), cinnabees);
    }

    @Override
    public int size() {
        return desserts.size();
    }

    @Override
    public boolean isEmpty() {
        return desserts.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return desserts.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return desserts.containsValue(value);
    }

    @Override
    public Dessert get(Object key) {
        return desserts.get(key);
    }

    @Override
    public Dessert put(String key, Dessert value) {
        return desserts.put(key, value);
    }

    @Override
    public Dessert remove(Object key) {
        return desserts.remove(key);
    }

    @Override
    public void putAll(Map m) {
        desserts.putAll(m);
    }

    @Override
    public void clear() {
        desserts.clear();
    }

    @Override
    public Set<String> keySet() {
        return desserts.keySet();
    }

    @Override
    public Collection values() {
        return desserts.values();
    }

    @Override
    public Set<Entry<String, Dessert>> entrySet() {
        return desserts.entrySet();
    }

}
