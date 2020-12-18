package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Config config;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("listTable"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml, String table) throws IOException {
        scene.setRoot(loadFXML(fxml, table));
    }

    static void setRoot(String fxml, ResultSet rs) throws IOException {
        scene.setRoot(loadFXML(fxml, rs));
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml, ""));
    }

    public static Parent loadFXML(String fxml, String table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();

        Controller controller = fxmlLoader.getController();
        controller.setData(table);

        return root;
    }

    public static Parent loadFXML(String fxml, ResultSet rs) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();

        Controller controller = fxmlLoader.getController();
        controller.setData(rs);

        return root;
    }

    public static Parent loadFXML(String fxml) throws IOException {
        return loadFXML(fxml, "");
    }

    public static void main(String[] args) {
        launch();
    }
}