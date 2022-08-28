package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.Side;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sides implements Map<String, Side> {
    static private Map<String, Side> sides = new HashMap();

    static {
        Side meatballs = new Side("Meatballs", 6.99);
        Side sausage = new Side("Sausage", 6.99);
        Side spaghetti = new Side("Spaghetti", 5.99);
        Side chicken = new Side("Chicken", 5.99);
        Side alfredoSauce = new Side("Alfredo Sauce", 3.99);
        Side meatSauce = new Side("Meat Sauce", 2.99);
        sides.put(meatballs.getName(), meatballs);
        sides.put(sausage.getName(), sausage);
        sides.put(spaghetti.getName(), spaghetti);
        sides.put(chicken.getName(), chicken);
        sides.put(alfredoSauce.getName(), alfredoSauce);
        sides.put(meatSauce.getName(), meatSauce);
    }

    public static Map<String, Side> getSides() {
        return sides;
    }

    @Override
    public int size() {
        return sides.size();
    }

    @Override
    public boolean isEmpty() {
        return sides.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return sides.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return sides.containsValue(value);
    }

    @Override
    public Side get(Object key) {
        return sides.get(key);
    }

    @Override
    public Side put(String key, Side value) {
        return sides.put(key, value);
    }

    @Override
    public Side remove(Object key) {
        return sides.remove(key);
    }

    @Override
    public void putAll(Map m) {
        sides.putAll(m);
    }

    @Override
    public void clear() {
        sides.clear();
    }

    @Override
    public Set<String> keySet() {
        return sides.keySet();
    }

    @Override
    public Collection values() {
        return sides.values();
    }

    @Override
    public Set<Entry<String, Side>> entrySet() {
        return sides.entrySet();
    }

}
