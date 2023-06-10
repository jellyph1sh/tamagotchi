package com.ynov.tamagochi;

import java.time.Instant;
import java.util.Random;

public class OldMan extends Tamagochi {
    protected Boolean isSick = false;
    public OldMan(Integer unitTime) {
        super(unitTime);
        this.Live();
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
            if (this.happiness <= 0) {
                this.isAlive = false;
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
            if (((this.lifetime/1000*this.unitTime) - (this.baseTimestamp/1000*this.unitTime)) >= 5) {
                this.GrowUp();
                isGrowing = true;
            }
        }
    }
}
