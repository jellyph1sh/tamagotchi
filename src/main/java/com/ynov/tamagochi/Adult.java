package com.ynov.tamagochi;

import java.time.Instant;

public class Adult extends Tamagochi{
    public Adult(Integer unitTime, Integer hunger, Integer happiness) {
        super(unitTime);
        this.hunger = hunger;
        this.happiness = happiness;
        this.Live();
    }

    @Override
    protected Tamagochi GrowUp(){
        System.out.println("Become a old man!");
        return new OldMan(this.unitTime);
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
            if (((this.lifetime/1000*this.unitTime) - (this.baseTimestamp/1000*this.unitTime)) >= 15) {
                this.GrowUp();
                isGrowing = true;
            }
        }
    }
}
