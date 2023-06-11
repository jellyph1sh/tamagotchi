package com.ynov.UI;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PlayView extends Thread{
    public String selectedWireColor = "";
    public String selectedWirePos = "";
    public ArrayList<String> joinedWires = new ArrayList<String>();

    public void run(Stage stage) {
        this.showGame(stage);
    }

    public void showGame(Stage stage) {
        Pane mainBox = new Pane();
        /* ------------------- Body ------------------ */
        /* ---------------- Background --------------- */
        Image backImg = new Image(getClass().getResource("img/playBackground.png").toExternalForm());
        ImageView backView  = new ImageView(backImg);
        /* ------------------------------------------- */

        /* ------------------- Wire ------------------ */
        HBox leftYellowWire = new HBox();
        leftYellowWire.setPrefSize(45, 20);
        leftYellowWire.relocate(0, 70);
        leftYellowWire.onMouseClickedProperty().set((e) -> {
            if (!this.joinedWires.contains("yellow")) {
                if (this.selectedWireColor.equals("yellow") && !this.selectedWirePos.equals("left")) {
                    this.joinedWires.add("yellow");
                } else {
                    this.selectedWireColor = "yellow";
                    this.selectedWirePos = "left";
                }
            }
        });

        HBox rightYellowWire = new HBox();
        rightYellowWire.setPrefSize(50, 20);
        rightYellowWire.relocate(350, 240);
        rightYellowWire.onMouseClickedProperty().set((e) -> {
            if (!this.joinedWires.contains("yellow")) {
                if (this.selectedWireColor.equals("yellow") && !this.selectedWirePos.equals("left")) {
                    this.joinedWires.add("yellow");
                } else {
                    this.selectedWireColor = "yellow";
                    this.selectedWirePos = "left";
                }
            }
        });


        HBox leftRedWire = new HBox();
        leftRedWire.setPrefSize(45, 20);
        leftRedWire.relocate(0, 240);
        leftRedWire.onMouseClickedProperty().set((e) -> {
            if (!this.joinedWires.contains("red")) {
                if (this.selectedWireColor.equals("red") && !this.selectedWirePos.equals("left")) {
                    this.joinedWires.add("red");
                } else {
                    this.selectedWireColor = "red";
                    this.selectedWirePos = "left";
                }
            }
        });

        HBox rightRedWire = new HBox();
        rightRedWire.setPrefSize(50, 20);
        rightRedWire.relocate(350, 70);
        rightRedWire.onMouseClickedProperty().set((e) -> {
            if (!this.joinedWires.contains("red")) {
                if (this.selectedWireColor.equals("red") && !this.selectedWirePos.equals("left")) {
                    this.joinedWires.add("red");
                } else {
                    this.selectedWireColor = "red";
                    this.selectedWirePos = "left";
                }
            }
        });


        HBox leftGreenWire = new HBox();
        leftGreenWire.setPrefSize(45, 20);
        leftGreenWire.relocate(0, 320);
        leftGreenWire.onMouseClickedProperty().set((e) -> {
            if (!this.joinedWires.contains("green")) {
                if (this.selectedWireColor.equals("green") && !this.selectedWirePos.equals("left")) {
                    this.joinedWires.add("green");
                } else {
                    this.selectedWireColor = "green";
                    this.selectedWirePos = "left";
                }
            }
        });

        HBox rightGreenWire = new HBox();
        rightGreenWire.setPrefSize(50, 20);
        rightGreenWire.relocate(350, 320);
        rightGreenWire.onMouseClickedProperty().set((e) -> {
            if (!this.joinedWires.contains("green")) {
                if (this.selectedWireColor.equals("green") && !this.selectedWirePos.equals("left")) {
                    this.joinedWires.add("green");
                } else {
                    this.selectedWireColor = "green";
                    this.selectedWirePos = "left";
                }
            }
        });


        HBox leftBlueWire = new HBox();
        leftBlueWire.setPrefSize(45, 20);
        leftBlueWire.relocate(0, 155);
        leftBlueWire.onMouseClickedProperty().set((e) -> {
            if (!this.joinedWires.contains("blue")) {
                if (this.selectedWireColor.equals("blue") && !this.selectedWirePos.equals("left")) {
                    this.joinedWires.add("blue");
                } else {
                    this.selectedWireColor = "blue";
                    this.selectedWirePos = "left";
                }
            }
        });

        HBox rightBlueWire = new HBox();
        rightBlueWire.getStyleClass().add("test");
        rightBlueWire.setPrefSize(50, 20);
        rightBlueWire.relocate(350, 155);
        rightBlueWire.onMouseClickedProperty().set((e) -> {
            if (!this.joinedWires.contains("blue")) {
                if (this.selectedWireColor.equals("blue") && !this.selectedWirePos.equals("left")) {
                    this.joinedWires.add("blue");
                } else {
                    this.selectedWireColor = "blue";
                    this.selectedWirePos = "left";
                }
            }
        });

        /* ------------------------------------------- */



        mainBox.getChildren().addAll(backView, leftBlueWire, leftGreenWire, leftRedWire, leftYellowWire, rightBlueWire, rightGreenWire, rightRedWire, rightYellowWire);
        /* ------------------------------------------- */
        


        Scene mainScene = new Scene(mainBox, 400, 400);
        mainScene.getStylesheets().add(getClass().getResource("css/main.css").toExternalForm());
        stage.setScene(mainScene);
        stage.show();
    }
}
