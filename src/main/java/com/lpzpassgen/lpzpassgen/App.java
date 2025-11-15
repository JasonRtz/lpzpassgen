package com.lpzpassgen.lpzpassgen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Load initial FXML
        Parent root = loadFXML("controller");

        // Get the screen where the stage will appear
        List<Screen> screens = Screen.getScreensForRectangle(
                stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight()
        );

        Screen targetScreen = screens.isEmpty() ? Screen.getPrimary() : screens.get(0);
        Rectangle2D bounds = targetScreen.getVisualBounds();

        // Scale window size relative to screen resolution (70% here)
        double width = bounds.getWidth() * 0.7;
        double height = bounds.getHeight() * 0.7;

        scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.setResizable(true); // allow resizing
        stage.show();

        // Adjust size again if user moves window to another monitor
        stage.xProperty().addListener((obs, oldVal, newVal) -> adjustToScreen(stage));
        stage.yProperty().addListener((obs, oldVal, newVal) -> adjustToScreen(stage));
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private void adjustToScreen(Stage stage) {
        List<Screen> screens = Screen.getScreensForRectangle(
                stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight()
        );

        Screen targetScreen = screens.isEmpty() ? Screen.getPrimary() : screens.get(0);
        Rectangle2D bounds = targetScreen.getVisualBounds();

        stage.setWidth(bounds.getWidth() * 0.7);
        stage.setHeight(bounds.getHeight() * 0.7);
    }

    public static void main(String[] args) {
        launch();
    }
}
