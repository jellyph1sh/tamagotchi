package com.ynov;

import com.ynov.tamagochi.Egg;
import com.ynov.tamagochi.Tamagochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;

import com.ynov.UI.Menu;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        int time = 5;
        Tamagochi tam = new Egg(time);
        if(Files.exists(UnitTime.DB_PATH)){
            try {
                Tamagochi tamLoad = UnitTime.loadSave();
                if (tamLoad != null) {
                    tam = tamLoad;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Menu menu = new Menu(stage, tam);
        UnitTime game = new UnitTime(time, tam, menu);
        game.thread();

    }

    public static void main(String[] args) {
        launch();
    }
}