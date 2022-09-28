package com.restaurant.restaurant_app.data;

import com.restaurant.restaurant_app.entities.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Users implements Map<String, User>{
    static private Map<String, User> users = new HashMap<>();;

    static {
        User user1 = new User("Korey", "1706386");
        User user2 = new User("Connor", "0000000");
        User user3 = new User("Cody", "0000001");
        User user4 = new User("Kyle", "0000002");
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);
        users.put(user4.getId(), user4);
    }

    public static User loginUser(String id) {
        User user = users.get(id);
        if (user != null) {
            return user;
        } else return null;
    }

    @Override
    public int size() {
        return users.size();
    }

    @Override
    public boolean isEmpty() {
        return users.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return users.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return users.containsValue(value);
    }

    @Override
    public User get(Object key) {
        return users.get(key);
    }

    @Override
    public User put(String key, User value) {
        return users.put(key, value);
    }

    @Override
    public User remove(Object key) {
        return users.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends User> m) {
        users.putAll(m);
    }

    @Override
    public void clear() {
        users.clear();
    }

    @Override
    public Set<String> keySet() {
        return users.keySet();
    }

    @Override
    public Collection<User> values() {
        return users.values();
    }

    @Override
    public Set<Entry<String, User>> entrySet() {
        return users.entrySet();
    }
}
