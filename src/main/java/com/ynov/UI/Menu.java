package com.ynov.UI;

import java.io.FileInputStream;

import com.ynov.tamagochi.Tamagochi;
import java.io.FileNotFoundException; 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.skin.LabeledSkinBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import com.ynov.UI.games.Play;

public class Menu extends Thread {
    private String currentMenu = "home";
    private Stage stage;
    public String tamImg; 
    public Tamagochi tam;

    public Menu(Stage stage, Tamagochi tam) {
        this.stage = stage;
        this.tamImg = "egg";
        this.tam = tam;
    }

    public void ShowMenus(Tamagochi tam) {
        switch (this.currentMenu) {
            case "home": {
                try {
                    this.showHome(tam);
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                }
                break;
            }
            case "gameChoice": {
                this.showGames(tam);
            }
        }
    }

    private void showHome(Tamagochi tam) throws FileNotFoundException {
        Pane mainVbox = new Pane();
        /*------------------ Body ------------------- */
        /*  <------------- Backgroung ------------->  */
        Pane background = new Pane();
        
        Image backImg = new Image(getClass().getResource("img/background.png").toExternalForm());
        ImageView backView = new ImageView(backImg);

        background.getChildren().add(backView);
        /*  <-------------------------------------->  */

        /*  <--------------- Stats ---------------->  */
        HBox statsBox = new HBox();
        statsBox.getStyleClass().add("stats");
        statsBox.setPrefWidth(400);
        statsBox.setPrefHeight(100);
        statsBox.relocate(0, 0);

        // Add les image plus tard
        // Image happinessBar = new Image(getClass().getResource("img/HappinessBar.png").toExternalForm());
        // ImageView hpsBarView = new ImageView(happinessBar);

        HBox hpsBox = new HBox();
        hpsBox.getStyleClass().add("box");

        Label hpsLabel = new Label("Happiness : ");
        Label hpsValue = new Label("0");
        hpsBox.getChildren().addAll(hpsLabel, hpsValue);


        HBox hungerBox = new HBox();
        hungerBox.getStyleClass().add("box");

        Label hungerLabel = new Label("Hunger : ");
        Label hungerValue = new Label("0");
        hungerBox.getChildren().addAll(hungerLabel, hungerValue);

        HBox dirtyBox = new HBox();
        dirtyBox.getStyleClass().add("box");

        Label dirtyLabel = new Label("IsDirty : ");
        Label dirtyValue = new Label("NO");
        dirtyBox.getChildren().addAll(dirtyLabel, dirtyValue);

        HBox lifeTimeBox = new HBox();
        lifeTimeBox.getStyleClass().add("box");

        Label lifeTimeLabel = new Label("Life Time : ");
        Label lifeTimeValue = new Label("0");
        lifeTimeBox.getChildren().addAll(lifeTimeLabel, lifeTimeValue);
        

        statsBox.getChildren().addAll(hpsBox, hungerBox, dirtyBox, lifeTimeBox);
        /*  <-------------------------------------->  */

        /*  <------------- Tamagochi -------------->  */
        HBox tamagochiBox = new HBox();
        tamagochiBox.getStyleClass().add("tamagochiBox");
        if ("oldMan".equals(this.tamImg)) {
            tamagochiBox.relocate(-30, 50);
        } else if ("baby".equals(this.tamImg)) {
            tamagochiBox.relocate(190, 220);
        } else {
            tamagochiBox.relocate(170, 190);
        }
        Image tamagochiImage = new Image(getClass().getResource("img/"+tam.status+".png").toExternalForm());
        ImageView tamagochiView = new ImageView(tamagochiImage);
        
        tamagochiBox.getChildren().add(tamagochiView);
        /*  <-------------------------------------->  */

        /*  <--------------- Games ---------------->  */
        Pane pc = new Pane();
        pc.setPrefSize(50, 50);
        pc.relocate(97, 150);
        pc.onMouseClickedProperty().set((e) -> {
            this.currentMenu = "gameChoice";
            this.ShowMenus(tam);
        });
        /*  <-------------------------------------->  */
        
        mainVbox.getChildren().addAll(background, tamagochiBox, statsBox, pc);
        /*------------------------------------------- */
        Scene mainScene = new Scene(mainVbox, 400, 400);
        mainScene.getStylesheets().add(getClass().getResource("css/main.css").toExternalForm());
        stage.setScene(mainScene);
        stage.show();
    }

    private void showGames(Tamagochi tam) {
        Pane mainBox = new Pane();
        /* ------------------ Body ------------------ */

        /*  <------------- Background ------------->  */
        Pane background = new Pane();
        
        Image backImg = new Image(getClass().getResource("img/background.png").toExternalForm());
        ImageView backView = new ImageView(backImg);

        background.getChildren().add(backView);
        /*  <-------------------------------------->  */

        /*  <---------------- Menu ---------------->  */
        Pane menu = new Pane();
        menu.setPrefSize(200, 300);
        menu.relocate(100, 50);
        menu.getStyleClass().add("menu");
        
        Label title = new Label("Games");
        title.setFont(new Font(30));
        title.relocate(55, 10);

        HBox leave = new HBox();
        leave.relocate(0, 0);
        Label leaveText = new Label("Leave");
        leaveText.setFont(new Font(24));
        leave.getChildren().add(leaveText);
        leave.getStyleClass().add("button");
        leave.setPrefSize(100, 50);
        leave.onMouseClickedProperty().set((e) -> {
            this.currentMenu = "home";
        });


        HBox play = new HBox();
        play.relocate(50, 80);
        Label playText = new Label("PLAY");
        playText.setFont(new Font(24));
        play.getChildren().add(playText);
        play.getStyleClass().add("button");
        play.setPrefSize(100, 50);
        play.onMouseClickedProperty().set((e) -> {
            tam.Play();
            this.currentMenu = "home";
            this.ShowMenus(tam);
        });

        HBox eat = new HBox();
        eat.relocate(50, 150);
        Label eatText = new Label("EAT");
        eatText.setFont(new Font(24));
        eat.getChildren().add(eatText);
        eat.getStyleClass().add("button");
        eat.setPrefSize(100, 50);
        eat.onMouseClickedProperty().set((e) -> {
            tam.Eat();
            this.currentMenu = "home";
            this.ShowMenus(tam);
        });

        HBox wash = new HBox();
        wash.relocate(50, 220);
        Label washText = new Label("WASH");
        washText.setFont(new Font(24));
        wash.getChildren().add(washText);
        wash.getStyleClass().add("button");
        wash.setPrefSize(100, 50);
        wash.onMouseClickedProperty().set((e) -> {
            tam.CleanUp();
            this.currentMenu = "home";
            this.ShowMenus(tam);
        });

        menu.getChildren().addAll(title, play, eat, wash);
        /*  <-------------------------------------->  */

        /*  <--------------- Stats ---------------->  */
        HBox statsBox = new HBox();
        statsBox.getStyleClass().add("stats");
        statsBox.setPrefWidth(400);
        statsBox.setPrefHeight(100);
        statsBox.relocate(0, 0);

        // Add les image plus tard
        // Image happinessBar = new Image(getClass().getResource("img/HappinessBar.png").toExternalForm());
        // ImageView hpsBarView = new ImageView(happinessBar);

        HBox hpsBox = new HBox();
        hpsBox.getStyleClass().add("box");

        Label hpsLabel = new Label("Happiness : ");
        Label hpsValue = new Label("0");
        hpsBox.getChildren().addAll(hpsLabel, hpsValue);


        HBox hungerBox = new HBox();
        hungerBox.getStyleClass().add("box");

        Label hungerLabel = new Label("Hunger : ");
        Label hungerValue = new Label("0");
        hungerBox.getChildren().addAll(hungerLabel, hungerValue);

        HBox dirtyBox = new HBox();
        dirtyBox.getStyleClass().add("box");

        Label dirtyLabel = new Label("IsDirty : ");
        Label dirtyValue = new Label("NO");
        dirtyBox.getChildren().addAll(dirtyLabel, dirtyValue);

        HBox lifeTimeBox = new HBox();
        lifeTimeBox.getStyleClass().add("box");

        Label lifeTimeLabel = new Label("Life Time : ");
        Label lifeTimeValue = new Label("0");
        lifeTimeBox.getChildren().addAll(lifeTimeLabel, lifeTimeValue);
        

        statsBox.getChildren().addAll(hpsBox, hungerBox, dirtyBox, lifeTimeBox);
        /*  <-------------------------------------->  */
        


        mainBox.getChildren().addAll(background, menu, statsBox);
        /*------------------------------------------- */

        Scene mainScene = new Scene(mainBox, 400, 400);
        mainScene.getStylesheets().add(getClass().getResource("css/main.css").toExternalForm());
        stage.setScene(mainScene);
        stage.show();
    }
}
