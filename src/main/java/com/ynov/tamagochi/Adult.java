package com.ynov.tamagochi;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import com.ynov.UI.Menu;

public class Adult extends Tamagochi{
    private long birthLifeTime = 0;
    public Adult(long unitTime, Integer hunger, Integer happiness) {
        super(unitTime);
        this.hunger = hunger;
        this.happiness = happiness;
        this.status = "adult";
    }

    @Override
    protected Tamagochi GrowUp(){
        System.out.println("Become a old man!");
        return new OldMan(this.unitTime);
    }

    public Tamagochi Live(){
        if (this.happiness <= 0) {
            this.isAlive = false;
            System.out.println("He died from sadness!");
        }
        if (this.birthLifeTime >= 15) {
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
