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
        // Remove tabs from listview item text (fooditem)
        String foodItemStr = Helper.removeLeadingTabs(foodListItemString);
        // Filter list of maps to get the map that contains the fooditem
        List<Map<String, ? extends FoodItem>> foodItemsListByCategory = DAO.allFoodItems.stream()
                .filter(foodCategory -> foodCategory.containsKey(foodItemStr))
                .collect(Collectors.toList());
        // List contains one map that contains the fooditem. Retrieve fooditem from the map
        FoodItem foodItem = (FoodItem) foodItemsListByCategory.get(0).get(foodItemStr).clone();
        return foodItem;
    }

    public static Topping searchTopping(String toppingName) throws CloneNotSupportedException {
        if (DAO.toppings.containsKey(toppingName)) {
            return (Topping) DAO.toppings.get(toppingName).clone();
        } else return null;
    }

    public static List<? extends FoodItem> getFoodItemsByCategory(Enums.FoodType foodType) {
        List<Map<String, ? extends FoodItem>> listContainingOneMap = DAO.allFoodItems.stream()
                .filter(map -> map.values()
                        .stream()
                        .toList()
                        .get(0)
                        .getFoodType().equals(foodType)
                )
                .toList();
        return listContainingOneMap.get(0).values().stream().toList();
    }
}
