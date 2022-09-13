package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.CartController;
import com.restaurant.restaurant_app.entities.FoodItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CartGUI {
    private final CartController cartController;
    private final MainGUI mainGUI;
    private VBox cartGUILayout;
    private VBox cartItemsLayout;
    private VBox totalLayout;
    private HBox cartButtonsLayout;
    private Button modifyBtn;
    private Button repeatBtn;
    private Button deleteBtn;
    private Label totalLabel;
    private ObservableList<FoodItem> cartList;
    private ListView<FoodItem> cartItemsListView;


    public CartGUI(MainGUI mainGUI, CartController cartController) {
        this.cartController = cartController;
        this.mainGUI = mainGUI;
        this.cartList = FXCollections.observableArrayList();
        this.cartItemsListView = new ListView<>(cartList);
        this.cartController.setCartGUI(this);
        initializeCartGUILayout();
    }

    private void initializeCartGUILayout() {
        this.cartGUILayout = new VBox();
        this.cartGUILayout.setPrefHeight(1024);
        this.cartItemsLayout = new VBox();
        this.cartItemsLayout.setPrefHeight(924);
        this.cartItemsListView.setPrefHeight(900);
        this.cartController.initializeCartItemCells();
        initializeButtons();
        this.cartButtonsLayout = new HBox();
        this.cartButtonsLayout.setPrefHeight(24);
        this.cartButtonsLayout.getChildren().addAll(this.modifyBtn, this.repeatBtn, this.deleteBtn);
        this.cartItemsLayout.getChildren().addAll(this.cartItemsListView, this.cartButtonsLayout);
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
        this.repeatBtn.setOnAction((ActionEvent) -> {this.cartController.repeatFoodItemFromCart();});
        this.deleteBtn = new Button("DELETE");
        this.deleteBtn.setOnAction((ActionEvent) -> {this.cartController.deleteFoodItemFromCart();});
    }

    public VBox getCartGUILayout() {
        return cartGUILayout;
    }

    public ObservableList<FoodItem> getCartList() {
        return cartList;
    }

    public VBox getCartItemsLayout() {
        return cartItemsLayout;
    }

    public Label getTotalLabel() {
        return totalLabel;
    }

    public ListView<FoodItem> getCartItemsListView() {
        return cartItemsListView;
    }
}
