package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.MainController;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class MainGUI {
    private final GridPane root;
    private final Stage stage;
    private MainController mainController;

    public MainGUI(Stage stage, MainController mainController) {
        // Create main Layouts and link them to the controller
        this.stage = stage;
        this.root = new GridPane();
        this.mainController = mainController;
        this.mainController.setMainGUI(this);
    }

    public GridPane getRoot() {
        return root;
    }

    public Stage getStage() {
        return stage;
    }

    public void linkSubGuisLayoutsToMainGuiLayout(CartGUI cartGUI, FoodCategoriesGUI foodCategoriesGUI, FoodItemsGUI foodItemsGUI) {
        // Set root's rows and columns constraints
        setRootsRowsConstraints();
        setRootsColumnsConstraints();
        this.root.setGridLinesVisible(true);
        addLayoutsToRoot(cartGUI, foodCategoriesGUI, foodItemsGUI);
    }

    private void setRootsRowsConstraints() {
        RowConstraints row = new RowConstraints();
        row.setPercentHeight(100);
        this.root.getRowConstraints().addAll(row);
    }

    private void setRootsColumnsConstraints() {
        ColumnConstraints cartColumn = new ColumnConstraints();
        cartColumn.setPercentWidth(40);
        ColumnConstraints foodCategoriesColumn = new ColumnConstraints();
        foodCategoriesColumn.setPercentWidth(20);
        ColumnConstraints foodItemsByCategoryColumn = new ColumnConstraints();
        foodItemsByCategoryColumn.setPercentWidth(40);
        this.root.getColumnConstraints().addAll(cartColumn, foodCategoriesColumn, foodItemsByCategoryColumn);
    }

    private void addLayoutsToRoot(CartGUI cartGUI, FoodCategoriesGUI foodCategoriesGUI, FoodItemsGUI foodItemsGUI) {
        this.root.add(cartGUI.getCartGUILayout(), 0, 0, 1, 1); // Row 0, Column 0
        this.root.add(foodCategoriesGUI.getFoodCategoriesLayout(), 1, 0, 1, 1); // Row 0, Column 1
        this.root.add(foodItemsGUI.getFoodItemsLayout(), 2, 0, 1, 1); // Row 0, Column 2
    }
}
