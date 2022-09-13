package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.ui.CartGUI;
import com.restaurant.restaurant_app.ui.ModifierPopupGUI;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ModifiersController {
    private MainController mainController;
    private CartGUI cartGUI;
    private ModifierPopupGUI modifierPopupGUI;

    public ModifiersController() {
        this.cartGUI = null;
        this.modifierPopupGUI = null;
    }

    public void populateModifiables(ListView<String> modifiablesListView, FoodItem foodItem) {
        if (foodItem.getToppings() != null) {
            for (Topping topping : foodItem.getToppings()) {
                modifiablesListView.getItems().add(topping.getName());
            }
        }
    }

    public void initializeModifiableCells() {
        this.modifierPopupGUI.getToppingsListView().setCellFactory(new Callback<>() {
            @Override
            public ListCell<String> call(ListView<String> p) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String t, boolean bln) {
                        super.updateItem(t, bln);
                        setText(t);
                        setOnMouseClicked(event -> {
                            String toppingName = getText();
                            Topping topping = null;
                            try {
                                topping = DataController.searchTopping(toppingName);
                            } catch (CloneNotSupportedException e) {
                                throw new RuntimeException(e);
                            }
                            if (getModifierPopupGUI().getAddBtn().isSelected()) {
                                setModifier(topping, Enums.ToppingModifier.ADD);
                                getModifierPopupGUI().getAddBtn().setSelected(false);
                            } else if (getModifierPopupGUI().getDeleteBtn().isSelected()) {
                                setModifier(topping, Enums.ToppingModifier.REMOVE);
                                getModifierPopupGUI().getDeleteBtn().setSelected(false);
                            } else if (getModifierPopupGUI().getExtraBtn().isSelected()) {
                                setModifier(topping, Enums.ToppingModifier.EXTRA);
                                getModifierPopupGUI().getExtraBtn().setSelected(false);
                            } else if (getModifierPopupGUI().getLightBtn().isSelected()) {
                                setModifier(topping, Enums.ToppingModifier.LIGHT);
                                getModifierPopupGUI().getLightBtn().setSelected(false);
                            }
                        });
                    }
                };
            }
        });
    }

    public void setModifier(Topping topping, Enums.ToppingModifier modifier) {
        if (getModifierPopupGUI().getFirstHalfBtn().isSelected()) {
            topping.setModifier(modifier);
            modifierPopupGUI.getFoodItem().addToppingFirstHalf(topping);
        } else if (getModifierPopupGUI().getSecondHalfBtn().isSelected()) {
            topping.setModifier(modifier);
            modifierPopupGUI.getFoodItem().addToppingSecondHalf(topping);
        } else {
            modifierPopupGUI.getFoodItem().getTopping(topping).setModifier(modifier);
        }
    }

    public ModifierPopupGUI getModifierPopupGUI() {
        return this.modifierPopupGUI;
    }

    public void setModifierPopupGUI(ModifierPopupGUI modifierPopupGUI) {
        this.modifierPopupGUI = modifierPopupGUI;
    }

    public void setCartGUI(CartGUI cartGUI) {
        this.cartGUI = cartGUI;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
