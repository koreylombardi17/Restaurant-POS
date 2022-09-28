package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.ui.*;
import com.restaurant.restaurant_app.ui.listviews.CartItemsListView;
import com.restaurant.restaurant_app.ui.listviews.FoodItemsListView;
import com.restaurant.restaurant_app.ui.listviews.ModifiersItemsListView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private Stage stage;
    private MainController mainController;
    private MainGUI mainGui;
    private CartItemsListView cartItemsListView;
    private ModifiersItemsListView modifiersItemsListView;
    private FoodItemsListView foodItemsListView;
    private FoodItemsGUI foodItemsGUI;
    private EmployeeLoginGUI employeeLoginGUI;
    private CartGUI cartGUI;
    private FoodCategoriesGUI foodCategoriesGUI;
    private ModifierPopupGUI modifierPopupGUI;
    private Scene mainGUIScene;
    private Scene employeeLoginGUIScene;

    public SceneController(Stage stage, MainController mainController) {
        this.stage = stage;
        this.stage.setTitle("Restaurant App");
        this.mainController = mainController;
        initializeGUIs();
        initializeScenes();
        setEmployeeLoginAsCurrentScene();
        this.stage.show();
    }

    private void initializeGUIs() {
        // Initialize app's main gui that contains sub gui's
        this.mainGui = new MainGUI(stage, mainController);

        // Initialize employee login gui
        this.employeeLoginGUI = new EmployeeLoginGUI(stage, mainController.getEmployeeLoginController());

        // Initialize sub-gui's
        this.foodItemsGUI = new FoodItemsGUI(mainController.getFoodItemsController());
        this.cartGUI = new CartGUI(mainController.getCartController());
        this.foodCategoriesGUI = new FoodCategoriesGUI();
        this.modifierPopupGUI = new ModifierPopupGUI(mainController);

        initializeListViews();

        // Listviews need initialized before code below can run
        this.cartGUI.initializeCartGUILayout();
        this.modifierPopupGUI.initializeModifierPopupGUI();

        linkControllers();
        addFunctionalityToGuis();

        // Link sub-gui's to main gui
        this.mainGui.linkTogetherLayouts(cartGUI, foodCategoriesGUI, foodItemsGUI);
    }

    private void initializeListViews() {
        this.cartItemsListView = new CartItemsListView();
        this.cartItemsListView.initializeListViewCells();
        this.cartGUI.setCartItemsListView(cartItemsListView);
        this.modifiersItemsListView = new ModifiersItemsListView(modifierPopupGUI, mainController.getModifiersController());
        this.modifierPopupGUI.setModifiersItemsListView(modifiersItemsListView);
        this.modifiersItemsListView.initializeListViewCells();
        this.foodItemsListView = new FoodItemsListView(modifierPopupGUI, foodItemsGUI, mainController.getDataController());
        this.foodItemsListView.initializeListViewCells();
        this.foodItemsGUI.setFoodItemsListView(foodItemsListView);
    }

    private void linkControllers() {
        this.mainController.getFoodItemsController().setMainGUI(mainGui);
        this.mainController.getCartController().setCartItemsListView(cartItemsListView);
        this.mainController.getCartController().setCartGUI(cartGUI);
        this.mainController.getFoodCategoriesController().setFoodCategoriesGUI(foodCategoriesGUI);
        this.mainController.getFoodItemsController().setModifierPopupGUI(modifierPopupGUI);
        this.mainController.getFoodItemsController().setFoodItemsListView(foodItemsListView);
    }

    private void addFunctionalityToGuis() {
        this.mainController.getFoodCategoriesController().setButtonsFunctionality();
        this.foodItemsGUI.initializeFoodItemsGui();
        this.foodItemsGUI.setFoodItemsLayout(foodItemsGUI.initializeFoodItemsLayout());
        this.mainController.getEmployeeLoginController().setButtonsFunctionality();
    }

    private void initializeScenes() {
        this.mainGUIScene = new Scene(mainGui.getRoot(), 1920, 1024);
        this.employeeLoginGUIScene = new Scene(employeeLoginGUI.getEmployeeLoginLayout(), 1920, 1024);
        this.employeeLoginGUIScene.getStylesheets().add("/employeeLoginGUIStyles.css");
    }

    public void setMainGuiAsCurrentScene() {
        this.stage.setScene(mainGUIScene);
    }

    public void setEmployeeLoginAsCurrentScene() {
        this.stage.setScene(employeeLoginGUIScene);
    }
}
