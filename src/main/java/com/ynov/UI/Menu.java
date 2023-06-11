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
    public Boolean goOut = false;

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
        Pane statsBox = new Pane();
        statsBox.getStyleClass().add("stats");
        statsBox.setPrefWidth(400);
        statsBox.setPrefHeight(100);
        statsBox.relocate(0, 0);

        // Add les image plus tard
        // Image happinessBar = new Image(getClass().getResource("img/HappinessBar.png").toExternalForm());
        // ImageView hpsBarView = new ImageView(happinessBar);

        HBox hpsBox = new HBox();
        hpsBox.getStyleClass().add("box");
        hpsBox.relocate(300, 50);
        Label hpsLabel = new Label("Happiness : ");
        Label hpsValue = new Label(""+tam.getHappiness());
        hpsBox.getChildren().addAll(hpsLabel, hpsValue);


        HBox hungerBox = new HBox();
        hungerBox.getStyleClass().add("box");
        hungerBox.relocate(165, 5);
        Label hungerLabel = new Label("Hunger : ");
        Label hungerValue = new Label(""+tam.getHunger());
        hungerBox.getChildren().addAll(hungerLabel, hungerValue);

        HBox dirtyBox = new HBox();
        dirtyBox.getStyleClass().add("box");
        dirtyBox.relocate(160, 35);
        Label dirtyLabel = new Label("IsDirty : ");
        Label dirtyValue = new Label(""+tam.getIsDirty());
        dirtyBox.getChildren().addAll(dirtyLabel, dirtyValue);

        HBox lifeTimeBox = new HBox();
        lifeTimeBox.getStyleClass().add("box");
        lifeTimeBox.relocate(20, 50);
        Label lifeTimeLabel = new Label("Life Time : ");
        Label lifeTimeValue = new Label(""+tam.getLifetime());
        lifeTimeBox.getChildren().addAll(lifeTimeLabel, lifeTimeValue);
        

        statsBox.getChildren().addAll(hpsBox, hungerBox, dirtyBox, lifeTimeBox);
        /*  <-------------------------------------->  */

        /*  <------------- Tamagochi -------------->  */
        HBox tamagochiBox = new HBox();
        tamagochiBox.getStyleClass().add("tamagochiBox");
        if ("oldMan".equals(tam.status)) {
            tamagochiBox.relocate(-30, 50);
        } else if ("baby".equals(tam.status)) {
            tamagochiBox.relocate(190, 220);
        } else {
            tamagochiBox.relocate(170, 190);
        }
        Image tamagochiImage = new Image(getClass().getResource("img/"+tam.status+".png").toExternalForm());
        ImageView tamagochiView = new ImageView(tamagochiImage);
        
        tamagochiBox.getChildren().add(tamagochiView);
        /*  <-------------------------------------->  */

        /*  <---------------- Exit ---------------->  */
        Pane exit = new Pane();
        exit.getStyleClass().add("test");
        exit.setPrefSize(87,75);
        exit.relocate(160, 62);
        exit.onMouseClickedProperty().set((e) -> {
            this.goOut = true;
        });
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
        
        mainVbox.getChildren().addAll(background, tamagochiBox, statsBox, pc, exit);
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

        HBox heal = new HBox();
        heal.relocate(50, 220);
        Label healText = new Label("HEAL");
        healText.setFont(new Font(24));
        heal.getChildren().add(healText);
        heal.getStyleClass().add("button");
        heal.setPrefSize(100, 50);
        heal.onMouseClickedProperty().set((e) -> {
            tam.Heal();
            this.currentMenu = "home";
            this.ShowMenus(tam);
        });

        menu.getChildren().addAll(title, play, eat, wash);
        /*  <-------------------------------------->  */
        
        mainBox.getChildren().addAll(background, menu);
        /*------------------------------------------- */

        Scene mainScene = new Scene(mainBox, 400, 400);
        mainScene.getStylesheets().add(getClass().getResource("css/main.css").toExternalForm());
        stage.setScene(mainScene);
        stage.show();
    }
}
