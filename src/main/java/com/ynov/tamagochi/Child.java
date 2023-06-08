package com.ynov.tamagochi;

import java.time.Instant;

public class Child extends Tamagochi{
    Child(Integer unitTime, Integer hunger, Integer happiness, long baseTimestamp, long lifetime){
        super(unitTime);
        this.hunger = hunger;
        this.happiness = happiness;
        this.baseTimestamp = baseTimestamp;
        this.lifetime = lifetime;
    }

    @Override
    protected Tamagochi GrowUp(){
        System.out.println("Become a real man!");
    }

    protected void Live() {
        Boolean isGrowing = false;
        while (isAlive && !isGrowing) {
            Instant instant = Instant.now();
            this.lifetime = instant.toEpochMilli();
            if (this.happiness >= 40) {
                this.GrowUp();
                isGrowing = true;
            }
        }
    }
}
