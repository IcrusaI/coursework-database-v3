package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateTableController extends Controller implements Initializable {
    String table = "";

    @FXML
    private VBox container;

    @FXML
    private Button createButton;

    @Override
    public void setData(String table) {
        this.table = table;

        getColumns();
    }

    private void getColumns() {
        try {
            ResultSet rs = getColumnsTable(table);

            while (rs.next()) {
                String name = rs.getString("COLUMN_NAME");

                TextField textField = new TextField();
                textField.setId(name);

                Label label = new Label(textConst.getString("tables." + table + "." + name));
                label.setGraphic(textField);
                label.setLabelFor(textField);


                container.getChildren().add(label);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void onCreate(ActionEvent event) {

        List<DataTable> dataTables = new ArrayList<DataTable>();

        for (Node node: container.getChildren()) {
            Label label = (Label) node;
            TextField textField = (TextField) label.getGraphic();

            DataTable dataTable = new DataTable();

            dataTable.name = textField.getId();
            dataTable.value = textField.getText();

            dataTables.add(dataTable);
        }

        try {
            createRowTable(table, dataTables);

            closeWindow();
        } catch (ClassNotFoundException | SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void closeWindow() {
        Stage stage = (Stage) createButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }
}
