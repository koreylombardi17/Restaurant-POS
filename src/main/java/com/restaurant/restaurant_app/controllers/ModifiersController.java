package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.ui.ModifierPopupGUI;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ModifiersController {
    private MainController mainController;
    private ModifierPopupGUI modifierPopupGUI;

    public ModifiersController() {
        this.modifierPopupGUI = null;
    }

    public void populateModifiables(ListView<String> modifiablesListView, FoodItem foodItem) {
        modifiablesListView.getItems().clear();
        if (!foodItem.getToppings().isEmpty()) {
            foodItem.getToppings().forEach(topping -> modifiablesListView.getItems().add(topping.getName()));
        }
    }

    public void setModifier(Topping topping, Enums.ToppingModifier modifier) {
        modifierPopupGUI.getFoodItem().getTopping(topping).setToppingModifier(modifier);

    }

    public void setModifierPopupGUI(ModifierPopupGUI modifierPopupGUI) {
        this.modifierPopupGUI = modifierPopupGUI;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
