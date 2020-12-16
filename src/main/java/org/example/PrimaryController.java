package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class PrimaryController extends Controller implements Initializable {
    @FXML
    private VBox tablesList;
    ToggleGroup group;

    @FXML
    private void openTable() {
        String id;
        try {
            RadioButton button = (RadioButton) group.getSelectedToggle();

            id = button.getId().replace("tables.", "");

            switchToSecondary(id);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, textConst.getString("errors.selectTable"), ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void switchToSecondary(String table) throws IOException {
        App.setRoot("secondary", table);
    }

    private void createTablesList() {
        ToggleGroup group = new ToggleGroup();

        this.group = group;
        for (Table table : config.tables) {
            RadioButton button = generateTableButton(table, group);
            tablesList.getChildren().add(button);
        }
    }

    private RadioButton generateTableButton(Table table, ToggleGroup group) {
        String title = textConst.getString("tables." + table.getName());

        RadioButton button = new RadioButton(title);
        button.setToggleGroup(group);
        button.setId("tables." + table.getName());

        return button;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createTablesList();
    }
}
