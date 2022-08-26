package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.Wing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Wings implements Map<String, Wing> {
    static private Map<String, Wing> wings = new HashMap();

    static {
        Wing mild = new Wing("Mild Wings", 12.99);
        Wing medium = new Wing("Medium Wings", 12.99);
        Wing hot = new Wing("Hot Wings", 12.99);
        Wing bbq = new Wing("BBQ Wings", 12.99);
        Wing teriyaki = new Wing("Teriyaki Wings", 12.99);
        Wing lemonPepper = new Wing("Lemon Pepper Wings", 12.99);
        wings.put(mild.getName(), mild);
        wings.put(medium.getName(), medium);
        wings.put(hot.getName(), hot);
        wings.put(bbq.getName(), bbq);
        wings.put(teriyaki.getName(), teriyaki);
        wings.put(lemonPepper.getName(), lemonPepper);
    }

    @Override
    public int size() {
        return wings.size();
    }

    @Override
    public boolean isEmpty() {
        return wings.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return wings.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return wings.containsValue(value);
    }

    @Override
    public Wing get(Object key) {
        return wings.get(key);
    }

    @Override
    public Wing put(String key, Wing value) {
        return wings.put(key, value);
    }

    @Override
    public Wing remove(Object key) {
        return wings.remove(key);
    }

    @Override
    public void putAll(Map m) {
        wings.putAll(m);
    }

    @Override
    public void clear() {
        wings.clear();
    }

    @Override
    public Set<String> keySet() {
        return wings.keySet();
    }

    @Override
    public Collection values() {
        return wings.values();
    }

    @Override
    public Set<Entry<String, Wing>> entrySet() {
        return wings.entrySet();
    }

}
