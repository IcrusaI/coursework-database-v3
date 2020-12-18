package org.example;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ListTableController extends Controller implements Initializable {
    @FXML
    private VBox tablesList;
    ToggleGroup group;
    @FXML
    private TextArea SQLRequest;

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
        App.setRoot("tableView", table);
    }

    @FXML
    private void switchToSecondary(ResultSet rs) throws IOException {
        App.setRoot("tableView", rs);
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

    @FXML
    private void openSQL() {
        String query = SQLRequest.getText();

        try {
            ResultSet rs = getQuery(query);

            SQLRequest.setText("");
            switchToSecondary(rs);
        } catch (ClassNotFoundException | SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createTablesList();
    }
}
