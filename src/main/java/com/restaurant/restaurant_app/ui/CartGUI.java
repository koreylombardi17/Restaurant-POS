package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.CartController;
import com.restaurant.restaurant_app.ui.listviews.CartItemsListView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CartGUI {
    private final CartController cartController;
    private CartItemsListView cartItemsListView;
    private VBox cartGUILayout;
    private VBox cartItemsLayout;
    private VBox totalLayout;
    private HBox cartButtonsLayout;
    private Button modifyBtn;
    private Button repeatBtn;
    private Button deleteBtn;
    private Label totalLabel;

    public CartGUI(CartController cartController) {
        this.cartController = cartController;
        this.cartController.setCartGUI(this);
    }

    public void initializeCartGUILayout() {
        this.cartGUILayout = new VBox();
        this.cartGUILayout.setPrefHeight(1024);
        this.cartItemsLayout = new VBox();
        this.cartItemsLayout.setPrefHeight(924);
        initializeButtons();
        this.cartButtonsLayout = new HBox();
        this.cartButtonsLayout.setPrefHeight(24);
        this.cartButtonsLayout.getChildren().addAll(this.modifyBtn, this.repeatBtn, this.deleteBtn);
        this.cartItemsLayout.getChildren().addAll(this.cartItemsListView.getCartItemsListView(), this.cartButtonsLayout);
        this.totalLayout = new VBox();
        this.totalLayout.setPrefHeight(100);
        this.totalLabel = new Label("$0.00");
        this.totalLayout.getChildren().add(this.totalLabel);
        this.cartGUILayout.getChildren().addAll(this.cartItemsLayout, this.totalLayout);
    }

    private void initializeButtons() {
        this.modifyBtn = new Button("MODIFY");
        this.modifyBtn.setOnAction((ActionEvent) -> {});
        this.repeatBtn = new Button("REPEAT");
//        this.repeatBtn.setOnAction((ActionEvent) -> {this.cartController.repeatFoodItemFromCart();});
        this.deleteBtn = new Button("DELETE");
//        this.deleteBtn.setOnAction((ActionEvent) -> {this.cartController.deleteFoodItemFromCart();});
    }

    public void setCartItemsListView(CartItemsListView cartItemsListView) {
        this.cartItemsListView = cartItemsListView;
    }

    public VBox getCartGUILayout() {
        return cartGUILayout;
    }

    public Label getTotalLabel() {
        return totalLabel;
    }
}
