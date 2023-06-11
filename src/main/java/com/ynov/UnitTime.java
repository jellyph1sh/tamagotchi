package com.ynov;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import com.ynov.UI.Menu;
import com.ynov.tamagochi.Egg;
import com.ynov.tamagochi.Tamagochi;

import javafx.application.Platform;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class UnitTime extends Thread{
    public static Path DB_PATH = Paths.get("./save.csv");
    private Tamagochi tam;
    private Menu menu;
    private long timeVal;

    public UnitTime(long timeVal, Tamagochi tamagochi, Menu menu) {
        this.tam = tamagochi;
        this.menu = menu;
        this.timeVal = timeVal;
    }

    public void thread() {
        if(Files.exists(DB_PATH)){
            try {
                this.tam = loadSave() ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
                    System.out.println("serializbale");
                    try {
                        this.serialize();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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

    private void serialize() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(baos);
        outputStream.writeObject(this.tam);
        byte[] data = baos.toByteArray();
        baos.close();
        outputStream.close();
        Files.write(DB_PATH,data);
    }

    public static Tamagochi loadSave() throws IOException {
        byte[] data = Files.readAllBytes(DB_PATH);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream inputStream = new ObjectInputStream(bais);
        Tamagochi tam = null;
        try{
            tam = (Tamagochi) inputStream.readObject();
        }catch(ClassNotFoundException e){
        }catch(IOException e){
        }
        return tam;
    }
}
