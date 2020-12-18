package org.example;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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

    @FXML
    private void refreshTable() throws IOException {
        tableView.getColumns().clear();

        requestTable(table);
    }

    @Override
    public void setData(String table) throws IOException {
        this.table = table;

        requestTable(table);
    }

    @Override
    public void setData(ResultSet data) throws IOException {
        System.out.println(data);
    }

    private void requestTable(String tableName) throws IOException {
        ResultSet rs = null;
        try {
            rs = getTable(tableName);

            ResultSetMetaData rsmd = rs.getMetaData();

            int count = rsmd.getColumnCount();

            int i = 1;
            while (i <= count) {
                String name = rsmd.getColumnName(i);

                // столбец для вывода имени
                TableColumn column = new TableColumn(textConst.getString("tables." + tableName + "." + name));
                // определяем фабрику для столбца с привязкой к свойству name
                column.setCellValueFactory(new PropertyValueFactory<>(name));

                tableView.getColumns().add(column);

                i++;
            }

            ObservableList data = FXCollections.observableArrayList();

            // iterate through the java resultset
            while (rs.next())
            {
                switch (tableName) {
                    case "bank":
                        data.add(new BankTableModel(
                                rs.getString("name")
                        ));
                        break;
                    case "bank_account":
                        data.add(new BankAccountTableModel(
                                rs.getInt("id"),
                                rs.getInt("quantity"),
                                rs.getInt("TIN")
                        ));
                        break;
                    case "calendar_credit":
                        data.add(new CalendarCreditTableModel(
                                rs.getInt("id"),
                                rs.getDate("date"),
                                rs.getInt("payment"),
                                rs.getInt("credit")
                        ));
                        break;
                    case "credit":
                        data.add(new CreditTableModel(
                                rs.getInt("id"),
                                rs.getInt("loan_amount"),
                                rs.getInt("remains"),
                                rs.getInt("credit_condition"),
                                rs.getInt("bank_account")
                        ));
                        break;
                    case "credit_conditions":
                        data.add(new CreditConditionTableModel(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("period"),
                                rs.getInt("bet"),
                                rs.getString("currency")
                        ));
                        break;
                    case "credit_history":
                        data.add(new CreditHistoryTableModel(
                                rs.getInt("id"),
                                rs.getInt("loan_amount"),
                                rs.getInt("remains"),
                                rs.getDate("expired"),
                                rs.getString("bank"),
                                rs.getInt("TIN"),
                                rs.getInt("repayment"),
                                rs.getInt("credit_condition")
                        ));
                        break;
                    case "currency":
                        data.add(new CurrencyTableModel(
                                rs.getString("name")
                        ));
                        break;
                    case "customers":
                        data.add(new CustomersTableModel(
                                rs.getInt("TIN"),
                                rs.getString("name"),
                                rs.getString("type"),
                                rs.getInt("revenue")
                        ));
                        break;
                    case "customer_types":
                        data.add(new CustomerTypesTableModel(
                                rs.getString("type")
                        ));
                        break;
                    case "payment_history":
                        data.add(new PaymentHistoryTableModel(
                                rs.getInt("id"),
                                rs.getInt("amount"),
                                rs.getString("recipient"),
                                rs.getInt("bank_account")
                        ));
                        break;
                    case "request_credit":
                        data.add(new RequestCreditTableModel(
                                rs.getInt("id"),
                                rs.getInt("loan_amount"),
                                rs.getInt("credit_condition"),
                                rs.getInt("TIN")
                        ));
                        break;
                }
            }

            tableView.setItems(data);
        } catch (ClassNotFoundException | SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
