package org.example;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import static org.example.App.loadFXML;

public class TableViewController extends Controller implements Initializable {
    @FXML
    TableView tableView;

    String table = "";

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("listTable");
    }

    @FXML
    private void openCreate() throws IOException {
        Scene scene = new Scene(loadFXML("createTable", table), 640, 480);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void setData(String table) {
        this.table = table;

        requestTable(table);
    }

    @Override
    public void setData(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();

            this.table = rsmd.getTableName(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        createTable(rs);
    }

    private void createTable(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int countColumns = rsmd.getColumnCount();
            String tableName = rsmd.getTableName(1);

            ObservableList<List<String>> data = FXCollections.observableArrayList();


            while (rs.next()) {
                List<String> row = new ArrayList<>();

                for (int i = 1; i <= countColumns; i++) {
                    row.add(rs.getString(i));
                }

                data.add(row);
            }

            for (int i = 0; i < countColumns; i++) {
                String columnName = rsmd.getColumnName(i + 1);

                String title;
                try {
                    title = textConst.getString("tables." + tableName + "." + columnName);
                } catch (Exception e) {
                    title = columnName;
                }

                TableColumn tc = new TableColumn(title);

                final int colNo = i;

                tc.setCellValueFactory((Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>) p ->
                        new SimpleStringProperty((p.getValue().get(colNo))));
                tableView.getColumns().add(tc);
            }
            tableView.setItems(data);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void requestTable(String tableName) {
        try {
            ResultSet rs = getTable(tableName);

            createTable(rs);
        } catch (ClassNotFoundException | SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
