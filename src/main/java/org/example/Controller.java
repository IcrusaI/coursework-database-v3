package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Controller  {
    public Config config;
    public ResourceBundle textConst;

    public void setData(String table) throws IOException {}
    public void setData(ResultSet data) throws IOException {};

    public Controller() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            config = xmlMapper.readValue(new File("src/main/resources/org/example/config.xml"), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        initLang();
    }

    private void initLang() {
        Locale locale = new Locale("ru", "RU");

        this.textConst = ResourceBundle.getBundle("org/example/lang", locale);
    }

    public ResultSet getTable(String table) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM `" + table + "`";

        return getQuery(query);
    }

    public ResultSet getColumnsTable(String table) throws ClassNotFoundException, SQLException {
        String query = "SELECT `COLUMN_NAME` FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE `TABLE_SCHEMA`='" + config.tableName + "' AND `TABLE_NAME`='" + table + "'";

        return getQuery(query);
    }

    public ResultSet createRowTable(String table, List<DataTable> dataTables) throws ClassNotFoundException, SQLException {
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (int i = 0; i < dataTables.size(); i++) {
            DataTable data = dataTables.get(i);

            keys.append("`").append(data.name).append("`");


            if (data.value.equals("")) {
                values.append("NULL");
            } else {
                values.append("'").append(data.value).append("'");
            }

            if (i + 1 < dataTables.size()) {
                keys.append(", ");
                values.append(", ");
            }
        }

        String query = "INSERT INTO `" + table + "` (" + keys + ") VALUES (" + values + ");";
        System.out.println(query);

        return getQuery(query);
    }


    public ResultSet getQuery(String query) throws ClassNotFoundException, SQLException {
            // create our mysql database connection
            String myDriver = "org.mariadb.jdbc.Driver";
            String myUrl = "jdbc:mariadb://localhost/" + config.tableName;
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            st.close();
            return rs;
    }

}

