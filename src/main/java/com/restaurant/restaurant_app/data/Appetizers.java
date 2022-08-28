package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.Appetizer;
import com.restaurant.restaurant_app.enums.Enums;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Appetizers implements Map<String, Appetizer> {
    static private Map<String, Appetizer> apps = new HashMap();

    static {
        Appetizer gcb = new Appetizer("Garlic Cheese Bread", 4.99);
        Appetizer spinDip = new Appetizer("Spinach Dip", 11.99);
        Appetizer calamari = new Appetizer("Calamari", 17.99);
        Appetizer cornNuggets = new Appetizer("Corn Nuggets", 17.99);
        Appetizer cheeseSticks = new Appetizer("Cheese Sticks", 17.99);
        Appetizer meatballApp = new Appetizer("Meatballs Appetizer", 14.99);
        Appetizer sausageApp = new Appetizer("Sausage Appetizer", 19.99);
        apps.put(gcb.getName(), gcb);
        apps.put(spinDip.getName(), spinDip);
        apps.put(calamari.getName(), calamari);
        apps.put(cornNuggets.getName(), cornNuggets);
        apps.put(cheeseSticks.getName(), cheeseSticks);
        apps.put(meatballApp.getName(), meatballApp);
        apps.put(sausageApp.getName(), sausageApp);
    }

    public static Map<String, Appetizer> getApps() {
        return apps;
    }

    @Override
    public int size() {
        return apps.size();
    }

    @Override
    public boolean isEmpty() {
        return apps.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return apps.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return apps.containsValue(value);
    }

    @Override
    public Appetizer get(Object key) {
        return apps.get(key);
    }

    @Override
    public Appetizer put(String key, Appetizer value) {
        return apps.put(key, value);
    }

    @Override
    public Appetizer remove(Object key) {
        return apps.remove(key);
    }

    @Override
    public void putAll(Map m) {
        apps.putAll(m);
    }

    @Override
    public void clear() {
        apps.clear();
    }

    @Override
    public Set<String> keySet() {
        return apps.keySet();
    }

    @Override
    public Collection values() {
        return apps.values();
    }

    @Override
    public Set<Entry<String, Appetizer>> entrySet() {
        return apps.entrySet();
    }

}
