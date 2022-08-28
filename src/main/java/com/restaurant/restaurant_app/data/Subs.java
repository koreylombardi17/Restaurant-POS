package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.Sub;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Subs implements Map<String, Sub> {
    static private Map<String, Sub> subs = new HashMap();

    static {
        Sub cheese = new Sub("Italian Sub", 9.99);
        Sub deluxe = new Sub("Chicken Parmesan Sub", 10.99);
        Sub veggie = new Sub("Philly Cheese Steak Sub", 10.99);
        Sub meat = new Sub("BLT Sub", 9.99);
        Sub hawaiian = new Sub("Veggie Sub", 8.99);
        Sub blt = new Sub("Meatball Sub", 9.99);
        subs.put(cheese.getName(), cheese);
        subs.put(deluxe.getName(), deluxe);
        subs.put(veggie.getName(), veggie);
        subs.put(meat.getName(), meat);
        subs.put(hawaiian.getName(), hawaiian);
        subs.put(blt.getName(), blt);
    }

    public static Map<String, Sub> getSubs() {
        return subs;
    }

    @Override
    public int size() {
        return subs.size();
    }

    @Override
    public boolean isEmpty() {
        return subs.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return subs.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return subs.containsValue(value);
    }

    @Override
    public Sub get(Object key) {
        return subs.get(key);
    }

    @Override
    public Sub put(String key, Sub value) {
        return subs.put(key, value);
    }

    @Override
    public Sub remove(Object key) {
        return subs.remove(key);
    }

    @Override
    public void putAll(Map m) {
        subs.putAll(m);
    }

    @Override
    public void clear() {
        subs.clear();
    }

    @Override
    public Set<String> keySet() {
        return subs.keySet();
    }

    @Override
    public Collection values() {
        return subs.values();
    }

    @Override
    public Set<Entry<String, Sub>> entrySet() {
        return subs.entrySet();
    }

}
