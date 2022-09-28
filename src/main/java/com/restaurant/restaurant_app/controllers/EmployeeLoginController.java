package com.restaurant.restaurant_app.controllers;

import com.restaurant.restaurant_app.data.Users;
import com.restaurant.restaurant_app.entities.User;
import com.restaurant.restaurant_app.ui.EmployeeLoginGUI;

public class EmployeeLoginController {
    private MainController mainController;
    private EmployeeLoginGUI employeeLoginGUI;
    private String userIdInput = "";

    //TODO : validate user by checking ids to see if user exists
    public EmployeeLoginController() {
        this.employeeLoginGUI = null;
    }

    public void setButtonsFunctionality() {
        this.employeeLoginGUI.getOneBtn().setOnAction(actionEvent -> oneButtonPressed());
        this.employeeLoginGUI.getTwoBtn().setOnAction(actionEvent -> twoButtonPressed());
        this.employeeLoginGUI.getThreeBtn().setOnAction(actionEvent -> threeButtonPressed());
        this.employeeLoginGUI.getFourBtn().setOnAction(actionEvent -> fourButtonPressed());
        this.employeeLoginGUI.getFiveBtn().setOnAction(actionEvent -> fiveButtonPressed());
        this.employeeLoginGUI.getSixBtn().setOnAction(actionEvent -> sixButtonPressed());
        this.employeeLoginGUI.getSevenBtn().setOnAction(actionEvent -> sevenButtonPressed());
        this.employeeLoginGUI.getEightBtn().setOnAction(actionEvent -> eightButtonPressed());
        this.employeeLoginGUI.getNineBtn().setOnAction(actionEvent -> nineButtonPressed());
        this.employeeLoginGUI.getZeroBtn().setOnAction(actionEvent -> zeroButtonPressed());
        this.employeeLoginGUI.getClearBtn().setOnAction(actionEvent -> clearButtonPressed());
        this.employeeLoginGUI.getEnterBtn().setOnAction(actionEvent -> enterButtonPressed());
    }

    private void oneButtonPressed() {
        this.userIdInput += "1";
    }

    private void twoButtonPressed() {
        this.userIdInput += "2";
    }

    private void threeButtonPressed() {
        this.userIdInput += "3";
    }

    private void fourButtonPressed() {
        this.userIdInput += "4";
    }

    private void fiveButtonPressed() {
        this.userIdInput += "5";
    }

    private void sixButtonPressed() {
        this.userIdInput += "6";
    }

    private void sevenButtonPressed() {
        this.userIdInput += "7";
    }

    private void eightButtonPressed() {
        this.userIdInput += "8";
    }

    private void nineButtonPressed() {
        this.userIdInput += "9";
    }

    private void zeroButtonPressed() {
        this.userIdInput += "0";
    }

    private void enterButtonPressed() {
        User loginUser = Users.loginUser(this.userIdInput);
        if (loginUser != null) {
            System.out.println(loginUser.getName() + " is logged in");
            this.mainController.getSceneController().setMainGuiAsCurrentScene();
        } else {
            System.out.println("User not found. Please try again");
            this.userIdInput = "";
        }
    }

    private void clearButtonPressed() {
        this.userIdInput = "";
    }


    public void setEmployeeLoginGUI(EmployeeLoginGUI employeeLoginGUI) {
        this.employeeLoginGUI = employeeLoginGUI;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
