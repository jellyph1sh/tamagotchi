package com.ynov.tamagochi;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import com.ynov.UI.Menu;

public class Child extends Tamagochi{
    Integer eatTime = 0;
    long lastEatTime = 0;

    public Child(long unitTime, Integer hunger, Integer happiness) {
        super(unitTime);
        this.hunger = hunger;
        this.happiness = happiness;
        this.status = "baby";
    }

    @Override
    public void Eat() {
        this.eatTime++;
        this.hasEaten = true;
        System.out.println("Eggs can eat!");
    };

    @Override
    protected Tamagochi GrowUp() {
        System.out.println("Become a real man!");
        return new Adult(this.unitTime, this.hunger, this.happiness);
    }

    public Tamagochi Live() {
        this.lifetime++;
        if (this.happiness <= 0) {
            this.isAlive = false;
            this.status = "dead";
            System.out.println("He died from sadness!");
        }
        if (this.happiness >= 40 && this.eatTime >= 4) {
            return this.GrowUp();
        }
        if (this.hasEaten) {
            this.eatTime++;
            this.isDirty = true;
        } else {
            this.eatTime = 0;
            this.hunger += 5;
        }

        if (this.hasAlreadyPlayed == 0) {
            this.happiness -= 10;
        }
        this.hasAlreadyPlayed = 0;
        return this;
    }
}
