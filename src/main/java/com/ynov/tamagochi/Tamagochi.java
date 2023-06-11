package com.ynov.tamagochi;

import com.ynov.UI.Menu;

public abstract class Tamagochi extends Thread{
    protected Boolean hasEaten = false;
    protected long baseTimestamp;
    protected long lifetime;
    protected Integer happiness = 15;
    protected Integer hasAlreadyPlayed = 0;
    protected long unitTime = 1;
    protected Integer hunger = 5;
    protected Boolean isDirty = false;
    protected Boolean isAlive = true;
    public String status;
    
    Tamagochi(long unitTime){
        this.unitTime = unitTime;
    }

    abstract Tamagochi GrowUp();

    public long getLifetime(){
        return lifetime;
    }

    public Integer getHappiness(){
        return happiness;
    }

    public Integer getHunger(){
        return hunger;
    }
    public Boolean getHasEaten(){
        return hasEaten;
    }

    public Boolean getIsDirty(){
        return isDirty;
    }

    public void setHappiness(int val) {
        this.happiness = val;
    }

    public void setHunger(int val) {
        this.hunger = val;
    }

    public void Eat() {
        this.hasEaten = true;
        System.out.println("Your tamagochi has eaten!");
    };

    public void Play(){
        if (this.hasAlreadyPlayed < 3) {
            this.happiness += 3;
            if(this.happiness > 50){
                this.happiness = 50;
            }
            this.hasAlreadyPlayed ++;
            System.out.println("You played with your tamagochi!");
        } else {
            System.out.println("You played to much with your tamagochi!");
        }
    }

    public void CleanUp(){
        if (isDirty){
            this.isDirty = false;
            System.out.println("The tamagotchi is clean!");
        } else{
            System.out.println("The tamagotchi is already clean!");
        }
    }

    abstract public Tamagochi Live();
}
