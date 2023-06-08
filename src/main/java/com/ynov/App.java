package com.ynov;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.ynov.UI.Menu;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Menu menu = new Menu(stage);
        menu.ShowMenus();
    }

    public static void main(String[] args) {
        launch();
    }
}