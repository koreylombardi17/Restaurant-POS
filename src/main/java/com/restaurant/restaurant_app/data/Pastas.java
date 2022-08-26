package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.Pasta;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Pastas implements Map<String, Pasta> {
    static private Map<String, Pasta> pastas = new HashMap();

    static {
        Pasta lasagna = new Pasta("Lasagna", 13.99);
        Pasta fettAlf = new Pasta("Fettuccine Alfredo", 14.99);
        Pasta meatShells = new Pasta("Meat Stuffed Shells", 14.99);
        Pasta ziti = new Pasta("Baked Ziti", 13.99);
        Pasta cheeseShells = new Pasta("Cheese Stuffed Shells", 12.99);
        Pasta cheeseRavioli = new Pasta("Cheese Ravioli", 12.99);
        pastas.put(lasagna.getName(), lasagna);
        pastas.put(fettAlf.getName(), fettAlf);
        pastas.put(meatShells.getName(), meatShells);
        pastas.put(ziti.getName(), ziti);
        pastas.put(cheeseShells.getName(), cheeseShells);
        pastas.put(cheeseRavioli.getName(), cheeseRavioli);
    }

    @Override
    public int size() {
        return pastas.size();
    }

    @Override
    public boolean isEmpty() {
        return pastas.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return pastas.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return pastas.containsValue(value);
    }

    @Override
    public Pasta get(Object key) {
        return pastas.get(key);
    }

    @Override
    public Pasta put(String key, Pasta value) {
        return pastas.put(key, value);
    }

    @Override
    public Pasta remove(Object key) {
        return pastas.remove(key);
    }

    @Override
    public void putAll(Map m) {
        pastas.putAll(m);
    }

    @Override
    public void clear() {
        pastas.clear();
    }

    @Override
    public Set<String> keySet() {
        return pastas.keySet();
    }

    @Override
    public Collection values() {
        return pastas.values();
    }

    @Override
    public Set<Entry<String, Pasta>> entrySet() {
        return pastas.entrySet();
    }

}
