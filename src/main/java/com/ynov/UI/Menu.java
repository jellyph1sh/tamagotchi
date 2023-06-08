package com.ynov.UI;

import java.io.FileInputStream;
import com.ynov.tamagochi.Tamagochi;
import java.io.FileNotFoundException; 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu {
    private String currentMenu = "home";
    private Stage stage;
    public String tamImg; 

    public Menu(Stage stage) {
        this.stage = stage;
        this.tamImg = "adult";
    }    

    public void ShowMenus() {
        switch (this.currentMenu) {
            case "home": {
                try {
                    this.showHome();
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                }
                break;
            }
        }
    }

    private void showHome() throws FileNotFoundException {
        Pane mainVbox = new Pane();
        // Label title = new Label("Welcome Home", null);
        // HBox stats = new HBox();
        // Label t = new Label("gzb");
        // test.getStyleClass().add("stats");
        // test.getChildren().add(t);
        // mainVbox.getChildren().addAll(title, imgView, test);

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

        Image tamagochiImage = new Image(getClass().getResource("img/"+this.tamImg+".png").toExternalForm());
        ImageView tamagochiView = new ImageView(tamagochiImage);
        
        tamagochiBox.getChildren().add(tamagochiView);
        /*  <-------------------------------------->  */






        mainVbox.getChildren().addAll(background, tamagochiBox, statsBox);
        /*------------------------------------------- */
        Scene mainScene = new Scene(mainVbox, 400, 400);
        mainScene.getStylesheets().add(getClass().getResource("css/main.css").toExternalForm());
        stage.setScene(mainScene);
        stage.show();
    }
}
