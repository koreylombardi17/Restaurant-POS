package com.restaurant.restaurant_app.ui.listviews;

import com.restaurant.restaurant_app.controllers.DataController;
import com.restaurant.restaurant_app.controllers.ModifiersController;
import com.restaurant.restaurant_app.entities.Topping;
import com.restaurant.restaurant_app.enums.Enums;
import com.restaurant.restaurant_app.interfaces.ListViewWrapper;
import com.restaurant.restaurant_app.ui.ModifierPopupGUI;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ModifiersItemsListView implements ListViewWrapper {

    private ModifierPopupGUI modifierPopupGUI;
    private ModifiersController modifiersController;
    private ListView<String> modifiersListView;


    public ModifiersItemsListView(ModifierPopupGUI modifierPopupGUI, ModifiersController modifiersController) {
        this.modifierPopupGUI = modifierPopupGUI;
        this.modifiersController = modifiersController;
        this.modifiersListView = new ListView<>();
    }

    @Override
    public void initializeListViewCells() {
        this.modifiersListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<String> call(ListView<String> p) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String t, boolean bln) {
                        super.updateItem(t, bln);
                        setText(t);
                        setOnMouseClicked(event -> {
                            String toppingName = getText();
                            Topping topping = null;
                            try {
                                topping = DataController.searchTopping(toppingName);
                            } catch (CloneNotSupportedException e) {
                                throw new RuntimeException(e);
                            }
                            if (modifierPopupGUI.getAddBtn().isSelected()) {
                                modifiersController.setModifier(topping, Enums.ToppingModifier.ADD);
                                modifierPopupGUI.getAddBtn().setSelected(false);
                            } else if (modifierPopupGUI.getDeleteBtn().isSelected()) {
                                modifiersController.setModifier(topping, Enums.ToppingModifier.REMOVE);
                                modifierPopupGUI.getDeleteBtn().setSelected(false);
                            } else if (modifierPopupGUI.getExtraBtn().isSelected()) {
                                modifiersController.setModifier(topping, Enums.ToppingModifier.EXTRA);
                                modifierPopupGUI.getExtraBtn().setSelected(false);
                            } else if (modifierPopupGUI.getLightBtn().isSelected()) {
                                modifiersController.setModifier(topping, Enums.ToppingModifier.LIGHT);
                                modifierPopupGUI.getLightBtn().setSelected(false);
                            }
                        });
                    }
                };
            }
        });
    }

    public ListView<String> getModifiersListView() {
        return modifiersListView;
    }
}
