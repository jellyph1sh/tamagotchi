package com.ynov;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import com.ynov.UI.Menu;
import com.ynov.tamagochi.Tamagochi;

import javafx.application.Platform;
import java.nio.file.Path;


public class UnitTime extends Thread{
    private Path DB_PATH = Path.of("./save/save.csv");
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
            while (this.tam.isAlive && !this.menu.goOut) {
                Platform.runLater(() -> {
                    this.menu.ShowMenus(this.tam);
                });
                try {
                    TimeUnit.SECONDS.sleep(this.timeVal);
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
                if (this.menu.goOut) {
                    System.out.println("serializbale, it's not available right now");
                } else {
                    System.out.println(this.tam.status + ": "+this.tam.getLifetime() + " " +this.tam.getHappiness() + " " + this.tam.getHunger() + " " + this.tam.isAlive);
                    Platform.runLater(() -> {
                        Tamagochi newTam = this.tam.Live();
                        if (newTam.status != this.tam.status) {
                            this.tam = newTam;
                        }
                    });
                }
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
