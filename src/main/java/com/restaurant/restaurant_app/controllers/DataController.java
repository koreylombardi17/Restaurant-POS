package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.data.DAO;
import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.service.Helper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataController {
    private MainController mainController;

    public DataController() {

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public static FoodItem searchFoodItem(String foodListItemString) throws CloneNotSupportedException {
        String foodItemStr = Helper.removeLeadingTabs(foodListItemString);
        List<Map<String, ? extends FoodItem>> foodCategoryList = DAO.allFoodItems.stream()
                .filter(foodCategory -> foodCategory.containsKey(foodItemStr))
                .collect(Collectors.toList());
        FoodItem clone = (FoodItem) foodCategoryList.get(0).get(foodItemStr).clone();
        return clone;
    }

    public static Topping searchTopping(String toppingName) throws CloneNotSupportedException {
        if (DAO.toppings.containsKey(toppingName)) {
            return (Topping) DAO.toppings.get(toppingName).clone();
        } else return null;
    }

    public static Collection<? extends FoodItem> getFoodItemsByCategory(Enums.FoodType foodType) {
        List<Map<String, ? extends FoodItem>> listContainingOneMap = DAO.allFoodItems.stream()
                .filter(map -> map.values()
                        .stream()
                        .toList()
                        .get(0)
                        .getFoodType().equals(foodType)

                )
                .toList();
        return listContainingOneMap.get(0).values();
    }
}
