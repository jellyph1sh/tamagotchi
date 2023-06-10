package com.ynov.tamagochi;

import java.time.Instant;

public class Child extends Tamagochi{
    Integer eatTime = 0;
    long lastEatTime = 0;

    public Child(Integer unitTime, Integer hunger, Integer happiness) {
        super(unitTime);
        this.hunger = hunger;
        this.happiness = happiness;
        this.Live();
    }

    @Override
    protected void Eat() {
        if (this.lastEatTime == 0 || ((this.lastEatTime/1000*this.unitTime) - (Instant.now().toEpochMilli()/1000*this.unitTime) <= 1)) {
            this.eatTime += 1;
            this.lastEatTime = Instant.now().toEpochMilli();
        } else {
            this.lastEatTime = 0;
            this.eatTime = 0;
        }
        System.out.println("Eggs can eat!");
    };

    @Override
    protected Tamagochi GrowUp() {
        System.out.println("Become a real man!");
        return new Adult(this.unitTime, this.hunger, this.happiness);
    }

    protected void Live() {
        Boolean isGrowing = false;
        this.baseTimestamp = Instant.now().toEpochMilli();
        while (isAlive && !isGrowing) {
            this.lifetime = Instant.now().toEpochMilli();
            if (this.happiness <= 0) {
                this.isAlive = false;
                System.out.println("He died from sadness!");
            }
            if (this.happiness >= 40 && this.eatTime == 4) {
                this.GrowUp();
                isGrowing = true;
            }
        }
    }
}
