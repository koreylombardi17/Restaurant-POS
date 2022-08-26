package com.restaurant.restaurant_app.service;

import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.text.DecimalFormat;

public class Helper {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Helper() {}

    public static void setBackgroundColor(Pane layout, Color color) {
        layout.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public static void setBackgroundColor(ListView listView, Color color) {
        listView.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public static String removeLeadingTabs(String str) {
        int indexOfSpace = str.indexOf('\t');
        return str.substring(indexOfSpace + 1);
    }

    public static String removeTrailingTabs(String str) {
        int indexOfTab = str.indexOf('\t');
        return str.substring(0, indexOfTab);
    }
    public static String formatTotal(double total) {
        if (total == 0) {
            return "Total = 0.00 $";
        }
        return "Total = " + df.format(total) + " $";
    }
}
