package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.FoodItemsController;
import com.restaurant.restaurant_app.controllers.MainController;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class MainGUI {
    private final GridPane root;
    private final Stage stage;
    private MainController mainController;
    private CartGUI cartGUI;
    private FoodCategoriesGUI foodCategoriesGUI;
    private FoodItemsGUI foodItemsGUI;

    public MainGUI(Stage stage) {
        // Create main Layouts and link them to the controller
        this.stage = stage;
        this.root = new GridPane();
        this.mainController = new MainController();
        this.mainController.setMainGUI(this);

        this.cartGUI = new CartGUI(this, mainController.getCartController());

        this.mainController.getCartController().setCartGUI(this.cartGUI);
        this.mainController.getModifiersController().setCartGUI(this.cartGUI);

        FoodItemsController foodItemsController = mainController.getFoodItemsController();
        foodItemsController.setMainGUI(this);

        this.foodCategoriesGUI = new FoodCategoriesGUI(this, foodItemsController, this.mainController.getFoodCategoriesController());
        this.mainController.getFoodCategoriesController().setFoodCategoriesGUI(this.foodCategoriesGUI);
        this.mainController.getFoodCategoriesController().setButtonsFunctionality();

        this.foodItemsGUI = new FoodItemsGUI(this, foodItemsController);
        this.foodItemsGUI.setFoodItemsLayout(this.foodItemsGUI.initializeFoodItemsLayout());

        // Set root's rows and columns constraints
        setRootsRowsConstraints();
        setRootsColumnsConstraints();

        this.root.setGridLinesVisible(true);
        addLayoutsToRoot();
    }

    public GridPane getRoot() {
        return root;
    }

    public Stage getStage() {
        return stage;
    }

    private void setRootsRowsConstraints() {
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(100);
        this.root.getRowConstraints().addAll(row);
    }

    private void setRootsColumnsConstraints() {
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(40);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(20);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(40);
        this.root.getColumnConstraints().addAll(column1, column2, column3);
    }

    private void addLayoutsToRoot() {
        this.root.add(this.cartGUI.getCartGUILayout(), 0, 0, 1, 1); // Row 0, Column 0
        this.root.add(this.foodCategoriesGUI.getFoodCategoriesLayout(), 1, 0, 1, 1); // Row 0, Column 1
        this.root.add(this.foodItemsGUI.getFoodItemsLayout(), 2, 0, 1, 1); // Row 0, Column 2
    }
}
