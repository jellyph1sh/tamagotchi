package com.ynov;

import com.ynov.tamagochi.Egg;
import com.ynov.tamagochi.Tamagochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Egg egg = new Egg(1);
        egg.Live();

    }

    public static void main(String[] args) {
        launch();
    }

}