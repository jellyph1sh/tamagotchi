package com.ynov.tamagochi;

import java.time.Instant;
import java.util.Random;

public class OldMan extends Tamagochi {
    protected Boolean isSick = false;
    public OldMan(Integer unitTime) {
        super(unitTime);
    }

    @Override
    protected Tamagochi GrowUp(){
        System.out.println("Die");
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

    public void Live() {
        Boolean isGrowing = false;
        this.baseTimestamp = Instant.now().toEpochMilli();
        while (isAlive && !isGrowing) {
            this.lifetime = Instant.now().toEpochMilli();
            if (isSick){
                isAlive = false;
            }
            Random rand = new Random();
            int randomNumber = rand.nextInt(2);
            if (randomNumber == 0){
                this.isSick = true;
            }
            if (((this.lifetime/1000*this.unitTime) - (this.baseTimestamp/1000*this.unitTime)) >= 5) {
                this.GrowUp();
                isGrowing = true;
            }
        }
    }
}
