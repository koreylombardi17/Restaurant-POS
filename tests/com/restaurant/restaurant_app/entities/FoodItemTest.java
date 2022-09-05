package com.restaurant.restaurant_app.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodItemTest {

    private Pizza pizza;

    @BeforeEach
    void setUp() {
        pizza = new Pizza("bbq pizza", 20.00);
    }

    @Test
    void setFoodType() {
    }

    @Test
    void addTopping() {
    }

    @Test
    void addToppingFirstHalf() {
    }

    @Test
    void addToppingSecondHalf() {
    }

    @Test
    void removeTopping() {
    }

    @Test
    void removeToppingFirstHalf() {
    }

    @Test
    void removeToppingSecondHalf() {
    }

    @Test
    void setPrice() {
        pizza.setPrice(20);
        int expResult = 20;
        assertEquals(expResult, pizza.getPrice());
        try {
            pizza.setPrice(-20);
            fail("Price should never be negative. Exception should be triggered");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught illegal argument exception: " + e.getMessage());
        } catch (Exception e) {
            fail("Wrong exception thrown for negative price");
        }
    }

    @Test
    void setToppings() {
    }

    @Test
    void setFirstHalfToppings() {
    }

    @Test
    void setSecondHalfToppings() {
    }

    @Test
    void testClone() {
    }
}