package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Controller {
    public Config config;
    public ResourceBundle textConst;

    public void setData(String table) {}

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

    public ResultSet getQuery(String table) throws ClassNotFoundException, SQLException {
            // create our mysql database connection
            String myDriver = "org.mariadb.jdbc.Driver";
            String myUrl = "jdbc:mariadb://localhost/lending_bank";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM `" + table + "`";

            // create the java statement
            Statement st = conn.createStatement();


            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            st.close();
            return rs;
    }
}
