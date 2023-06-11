package com.ynov.tamagochi;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.ynov.UI.Menu;

public class OldMan extends Tamagochi {
    protected Boolean isSick = false;
    public Boolean isDead = false;
    private long birthLifeTime = 0;  
    public OldMan(long unitTime) {
        super(unitTime);
        this.status = "oldMan";
    }

    @Override
    protected Tamagochi GrowUp(){
        System.out.println("Die");
        this.isDead = true;
        this.isAlive = false;
        this.status = "dead";
        return null;
    }    

    protected void Heal(){
        if (isSick){
            this.isSick = false;
            System.out.println("Old tamagotchi is no longer ill!");
        } else{
            System.out.println("Old tamagotchi isn't sick!");
        }
    }

    public Tamagochi Live() {
        this.lifetime++;
        if (this.happiness <= 0) {
            this.isAlive = false;
            this.status = "dead";
            System.out.println("He died from sadness!");
        }
        if (isSick){
            isAlive = false;
            System.out.println("He died from sick!");
        }
        Random rand = new Random();
        int randomNumber = rand.nextInt(2);
        if (randomNumber == 0){
            this.isSick = true;
        }
        if (this.birthLifeTime >= 5) {
            return this.GrowUp();
        } else {
            this.birthLifeTime++;
        }
        if (this.hasEaten) {
            this.isDirty = true;
        }
        this.hasAlreadyPlayed = 0;
        return this;
    }
}
