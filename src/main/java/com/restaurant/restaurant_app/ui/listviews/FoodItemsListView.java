package com.restaurant.restaurant_app.ui.listviews;

import com.restaurant.restaurant_app.controllers.DataController;
import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.interfaces.ListViewWrapper;
import com.restaurant.restaurant_app.ui.FoodItemsGUI;
import com.restaurant.restaurant_app.ui.ModifierPopupGUI;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class FoodItemsListView implements ListViewWrapper {
    private ModifierPopupGUI modifierPopupGUI;
    private FoodItemsGUI foodItemsGUI;
    private DataController dataController;
    private ListView<String> foodItemsListView;

    public FoodItemsListView(ModifierPopupGUI modifierPopupGUI, FoodItemsGUI foodItemsGUI, DataController dataController) {
        this.modifierPopupGUI = modifierPopupGUI;
        this.foodItemsGUI = foodItemsGUI;
        this.dataController = dataController;
        this.foodItemsListView = new ListView<>();
    }

    @Override
    public void initializeListViewCells() {
        this.foodItemsListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<String> call(ListView<String> p) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String t, boolean bln) {
                        super.updateItem(t, bln);
                        setText(t);
                        setOnMouseClicked(event -> {
                            String itemName = getText();
                            FoodItem foodItem = null;
                            try {
                                foodItem = dataController.searchFoodItem(itemName);
                            } catch (CloneNotSupportedException e) {
                                throw new RuntimeException(e);
                            }
                            modifierPopupGUI.setFoodItem(foodItem);
                            modifierPopupGUI.initializeDataForModifierPopupGUI();
                            modifierPopupGUI.show();
                        });
                    }
                };
            }
        });
    }

    public ListView<String> getFoodItemsListView() {
        return foodItemsListView;
    }
}
