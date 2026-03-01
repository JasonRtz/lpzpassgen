package com.lpzpassgen.lpzpassgen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("controller.fxml"));
        Parent root = fxmlLoader.load();

        // Set fixed initial size (smaller)
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Lpz Password Generator");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}