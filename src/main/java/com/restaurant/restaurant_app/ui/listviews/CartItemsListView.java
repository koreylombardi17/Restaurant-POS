package com.restaurant.restaurant_app.ui.listviews;

import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.interfaces.ListViewWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class CartItemsListView implements ListViewWrapper {

    private ObservableList<Object> cartList;
    private ListView<Object> cartItemsListView;

    public CartItemsListView() {
        this.cartList = FXCollections.observableArrayList();
        this.cartItemsListView = new ListView<>(cartList);
        this.cartItemsListView.setPrefHeight(900);
    }

    @Override
    public void initializeListViewCells() {
        this.cartItemsListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Object listCell, boolean empty) {
                super.updateItem(listCell, empty);
                if (empty || listCell == null) {
                    setText("");
                } else {
                    if (listCell.getClass().getSuperclass() == FoodItem.class) {
                        FoodItem foodItem = (FoodItem) listCell;
                        setText(foodItem.getName() + "\t" + foodItem.getPrice());
                    } else if (listCell.getClass() == Topping.class) {
                        Topping topping = (Topping) listCell;
                        setText("\t" + topping.getToppingModifier() + " " + topping.getName());
                    }
                }
                setOnMouseClicked(event -> {
                });
            }
        });
    }

    public ObservableList<Object> getCartList() {
        return cartList;
    }

    public ListView<Object> getCartItemsListView() {
        return cartItemsListView;
    }
}
