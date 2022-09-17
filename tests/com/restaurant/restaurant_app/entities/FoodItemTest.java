package com.restaurant.restaurant_app.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodItemTest {

    private Pizza underTest;

    @BeforeEach
    void setUp() {
        underTest = new Pizza("bbq pizza", 20.00);
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
        // When
        underTest.setPrice(20);
        // Then
        int expResult = 20;
        assertEquals(expResult, underTest.getPrice());

        try {
            // When
            underTest.setPrice(-20);
            fail("Price should never be negative. Exception should be triggered");
        } catch (IllegalArgumentException e) {
            // Passes test if here
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