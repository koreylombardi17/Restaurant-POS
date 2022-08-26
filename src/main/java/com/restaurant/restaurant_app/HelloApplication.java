package com.restaurant.restaurant_app;

import com.restaurant.restaurant_app.ui.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainGUI mainGui = new MainGUI(stage);
        Scene scene = new Scene(mainGui.getRoot(), 1920, 1024);
        stage.setTitle("Restaurant App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}