package com.restaurant.restaurant_app.enums;

public class Enums {
    public enum FoodType {
        APP,
        WINGS,
        SALAD,
        PIZZA,
        SPECIALITY_PIZZA,
        SUB,
        PASTA,
        SIDE,
        DESSERT,
    }

    public enum ToppingType {
        FULL, FIRSTHALF, SECONDHALF
    }

    public enum ToppingModifier implements Cloneable{
        ADD,
        REMOVE,
        EXTRA,
        LIGHT,
        NORMAL
    }
}
