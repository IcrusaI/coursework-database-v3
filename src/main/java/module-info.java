module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires com.fasterxml.jackson.dataformat.xml;
    requires java.sql;

    opens org.example to javafx.fxml;
    exports org.example;
}