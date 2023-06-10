package com.ynov.UI.games;

import java.util.ArrayList;

public class Play extends Thread{
    private String SelectedWireColor;
    private String SelectedWirePos;
    private ArrayList<String> linkedWires = new ArrayList<String>();
    private ArrayList<String> possiblesWire = new ArrayList<String>();

    public Play() {
        possiblesWire.add("yellow");
        possiblesWire.add("red");
        possiblesWire.add("blue");
        possiblesWire.add("green");
    }

    public void run() {
        while (!this.linkedWires.equals(this.possiblesWire)) {
            System.out.println("Run");
        }
    }

    public void selectWire(String pos, String color) {
        if (this.possiblesWire.contains(color)) {
            this.SelectedWireColor = color;
        }
        this.SelectedWirePos = pos;
    }

    public void connectWire(String color) {
        this.linkedWires.add(color);
    }
}
