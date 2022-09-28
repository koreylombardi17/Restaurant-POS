package com.restaurant.restaurant_app.ui;

import com.restaurant.restaurant_app.controllers.EmployeeLoginController;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EmployeeLoginGUI {
    private final GridPane employeeLoginLayout;
    private final Stage stage;
    private EmployeeLoginController employeeLoginController;
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private Button sevenBtn;
    private Button eightBtn;
    private Button nineBtn;
    private Button zeroBtn;
    private Button enterBtn;
    private Button clearBtn;

    public EmployeeLoginGUI(Stage stage, EmployeeLoginController employeeLoginController) {
        this.stage = stage;
        this.employeeLoginLayout = new GridPane();
        this.employeeLoginLayout.setHgap(3);
        this.employeeLoginLayout.setVgap(3);
        this.employeeLoginLayout.getStyleClass().add("grid-pane-container");
        this.employeeLoginController = employeeLoginController;
        this.employeeLoginController.setEmployeeLoginGUI(this);
        initializeButtonsLayout();
    }

    private void initializeButtonsLayout() {
        this.oneBtn = new Button("1");
        this.twoBtn = new Button("2");
        this.threeBtn = new Button("3");
        this.fourBtn = new Button("4");
        this.fiveBtn = new Button("5");
        this.sixBtn = new Button("6");
        this.sevenBtn = new Button("7");
        this.eightBtn = new Button("8");
        this.nineBtn = new Button("9");
        this.zeroBtn = new Button("0");
        this.clearBtn = new Button("CLEAR");
        this.enterBtn = new Button("ENTER");
        this.employeeLoginLayout.add(this.oneBtn, 0, 0);
        this.employeeLoginLayout.add(this.twoBtn, 1, 0);
        this.employeeLoginLayout.add(this.threeBtn, 2, 0);
        this.employeeLoginLayout.add(this.fourBtn, 0, 1);
        this.employeeLoginLayout.add(this.fiveBtn, 1, 1);
        this.employeeLoginLayout.add(this.sixBtn, 2, 1);
        this.employeeLoginLayout.add(this.sevenBtn, 0, 2);
        this.employeeLoginLayout.add(this.eightBtn, 1, 2);
        this.employeeLoginLayout.add(this.nineBtn, 2, 2);
        this.employeeLoginLayout.add(this.clearBtn, 0, 3);
        this.employeeLoginLayout.add(this.zeroBtn, 1, 3);
        this.employeeLoginLayout.add(this.enterBtn, 2, 3);
    }

    public GridPane getEmployeeLoginLayout() {
        return employeeLoginLayout;
    }

    public Button getOneBtn() {
        return oneBtn;
    }

    public Button getTwoBtn() {
        return twoBtn;
    }

    public Button getThreeBtn() {
        return threeBtn;
    }

    public Button getFourBtn() {
        return fourBtn;
    }

    public Button getFiveBtn() {
        return fiveBtn;
    }

    public Button getSixBtn() {
        return sixBtn;
    }

    public Button getSevenBtn() {
        return sevenBtn;
    }

    public Button getEightBtn() {
        return eightBtn;
    }

    public Button getNineBtn() {
        return nineBtn;
    }

    public Button getZeroBtn() {
        return zeroBtn;
    }

    public Button getEnterBtn() {
        return enterBtn;
    }

    public Button getClearBtn() {
        return clearBtn;
    }
}
