package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.Salad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Salads implements Map<String, Salad> {
    static private Map<String, Salad> salads = new HashMap();

    static {
        Salad tossedSalad = new Salad("Tossed Salad", 5.99);
        Salad caesarSalad = new Salad("Caesar Salad", 5.99);
        Salad gardenSalad = new Salad("Garden Salad", 8.99);
        Salad antipastoSalad = new Salad("Antipasto Salad", 11.99);
        Salad grilledChickenSalad = new Salad("Grilled Chicken Salad", 12.99);
        Salad greekSalad = new Salad("Greek Salad", 11.99);
        salads.put(tossedSalad.getName(), tossedSalad);
        salads.put(caesarSalad.getName(), caesarSalad);
        salads.put(gardenSalad.getName(), gardenSalad);
        salads.put(antipastoSalad.getName(), antipastoSalad);
        salads.put(grilledChickenSalad.getName(), grilledChickenSalad);
        salads.put(greekSalad.getName(), greekSalad);
    }

    public static Map<String, Salad> getSalads() {
        return salads;
    }

    @Override
    public int size() {
        return salads.size();
    }

    @Override
    public boolean isEmpty() {
        return salads.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return salads.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return salads.containsValue(value);
    }

    @Override
    public Salad get(Object key) {
        return salads.get(key);
    }

    @Override
    public Salad put(String key, Salad value) {
        return salads.put(key, value);
    }

    @Override
    public Salad remove(Object key) {
        return salads.remove(key);
    }

    @Override
    public void putAll(Map m) {
        salads.putAll(m);
    }

    @Override
    public void clear() {
        salads.clear();
    }

    @Override
    public Set<String> keySet() {
        return salads.keySet();
    }

    @Override
    public Collection values() {
        return salads.values();
    }

    @Override
    public Set<Entry<String, Salad>> entrySet() {
        return salads.entrySet();
    }

}
