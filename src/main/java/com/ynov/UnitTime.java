package com.ynov;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import com.ynov.UI.Menu;
import com.ynov.tamagochi.Tamagochi;

import javafx.application.Platform;

public class UnitTime extends Thread{
    private Tamagochi tam;
    private Menu menu;
    private long timeVal;

    public UnitTime(long timeVal, Tamagochi tamagochi, Menu menu) {
        this.tam = tamagochi;
        this.menu = menu;
        this.timeVal = timeVal;
    }

    public void thread() {
        new Thread(() -> {
            while (!this.tam.isAlive()) {
                Platform.runLater(() -> {
                    this.menu.ShowMenus(this.tam);
                });
                try {
                    TimeUnit.SECONDS.sleep(this.timeVal);
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(this.tam.status + ": "+this.tam.getLifetime() + " " +this.tam.getHappiness() + " " + this.tam.getHunger() + " ");
                Platform.runLater(() -> {
                    Tamagochi newTam = this.tam.Live();
                    if (newTam.status != this.tam.status) {
                        this.tam = newTam;
                    }
                });
            }
        }).start();
    }

    // public void run() {
    //     this.menu.ShowMenus();
    //     while (true) {
    //         System.out.print("gzonao");
    //         this.tam.Live();
    //         try {
    //             TimeUnit.SECONDS.sleep(this.timeVal);
    //         } catch (InterruptedException e) {
    //             System.out.println(e);
    //         }
    //     }
    // }
}
