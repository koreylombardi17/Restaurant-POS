package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.MainController;
import com.restaurant.restaurant_app.controllers.ModifiersController;
import com.restaurant.restaurant_app.entities.FoodItem;
import com.restaurant.restaurant_app.ui.listviews.ModifiersItemsListView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModifierPopupGUI {
    private MainController mainController;
    private ModifiersController modifiersController;
    private ModifiersItemsListView modifiersItemsListView;
    private FoodItem foodItem;
    private HBox topBtnsHBox;
    private HBox bottomBtnsHBox;
    private VBox popupVBox;
    private ToggleButton addBtn;
    private ToggleButton deleteBtn;
    private ToggleButton extraBtn;
    private ToggleButton lightBtn;
    private ToggleButton firstHalfBtn;
    private ToggleButton secondHalfBtn;
    private Button cancelBtn;
    private Button submitBtn;
    private Stage stage;

    public ModifierPopupGUI(MainController mainController) {
        this.mainController = mainController;
        this.modifiersController = mainController.getModifiersController();
        this.modifiersController.setModifierPopupGUI(this);
    }

    public void initializeModifierPopupGUI() {
        initializeStage(this.mainController);
        initializeButtons();
        initializeLayout();
        initializeScene();
    }

    public void setModifiersItemsListView(ModifiersItemsListView modifiersItemsListView) {
        this.modifiersItemsListView = modifiersItemsListView;
    }

    private void initializeScene() {
        Scene popupScene = new Scene(this.popupVBox, 1152, 1024);
        popupScene.getStylesheets().add("/modifierGUIStyles.css");
        this.stage.setScene(popupScene);
    }

    private void initializeLayout() {
        this.popupVBox = new VBox();
        this.popupVBox.getChildren().add(this.topBtnsHBox);
        this.popupVBox.getChildren().add(modifiersItemsListView.getModifiersListView());
        this.popupVBox.getChildren().add(this.bottomBtnsHBox);
    }

    private void initializeStage(MainController mainController) {
        this.stage = new Stage();
        stage.setX(1920);
        stage.setY(0);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(mainController.getMainGUI().getStage());
    }

    public void initializeDataForModifierPopupGUI() {
        this.modifiersController.populateModifiables(this.modifiersItemsListView.getModifiersListView(), foodItem);
        this.modifiersItemsListView.initializeListViewCells();
    }

    public void show() {
        stage.show();
    }

    private void initializeButtons() {
        ToggleGroup modifiersToggleGroup = new ToggleGroup();
        ToggleGroup halvesToggleGroup = new ToggleGroup();

        this.addBtn = new ToggleButton("ADD");
        this.addBtn.setToggleGroup(modifiersToggleGroup);

        this.deleteBtn = new ToggleButton("86");
        this.deleteBtn.setToggleGroup(modifiersToggleGroup);

        this.extraBtn = new ToggleButton("EXTRA");
        this.extraBtn.setToggleGroup(modifiersToggleGroup);

        this.lightBtn = new ToggleButton("LIGHT");
        this.lightBtn.setToggleGroup(modifiersToggleGroup);

        this.firstHalfBtn = new ToggleButton("1st Half");
        this.firstHalfBtn.setToggleGroup(halvesToggleGroup);

        this.secondHalfBtn = new ToggleButton("2nd Half");
        this.secondHalfBtn.setToggleGroup(halvesToggleGroup);

        this.topBtnsHBox = new HBox();
        this.topBtnsHBox.getChildren().addAll(this.addBtn, this.deleteBtn, this.extraBtn, this.lightBtn, this.firstHalfBtn, this.secondHalfBtn);

        this.cancelBtn = new Button("CANCEL");
        this.cancelBtn.setOnAction((ActionEvent event) -> {
            this.stage.close();
        });

        this.submitBtn = new Button("DONE");
        this.submitBtn.setOnAction((ActionEvent event) -> {
            mainController.getCartController().addFoodItemToCartListView(foodItem);
            this.stage.close();
        });

        this.bottomBtnsHBox = new HBox();
        this.bottomBtnsHBox.getChildren().addAll(this.cancelBtn, this.submitBtn);
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public ToggleButton getAddBtn() {
        return addBtn;
    }

    public ToggleButton getDeleteBtn() {
        return deleteBtn;
    }

    public ToggleButton getExtraBtn() {
        return extraBtn;
    }

    public ToggleButton getLightBtn() {
        return lightBtn;
    }

    public ToggleButton getFirstHalfBtn() {
        return firstHalfBtn;
    }

    public ToggleButton getSecondHalfBtn() {
        return secondHalfBtn;
    }

    public Button getCancelBtn() {
        return cancelBtn;
    }

    public Button getSubmitBtn() {
        return submitBtn;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
