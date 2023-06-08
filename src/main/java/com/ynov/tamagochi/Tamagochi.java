package com.ynov.tamagochi;

public abstract class Tamagochi {
    protected Boolean hasEaten = false;
    protected Integer lifetime = 0;
    protected Integer happiness = 15;
    protected Integer hasAlreadyPlayed = 0;
    protected Integer unitTime = 1;
    protected Integer hunger = 5;
    protected Boolean isDirty = false;
    
    Tamagochi(Integer unitTime){
        this.unitTime = unitTime;
    }

    abstract void GrowUp();

    public Integer getLifetime(){
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
    protected void Eat() {
        this.hasEaten = true;
        System.out.println("Your tamagochi has eaten");
    };

    protected void Play(){
        if (this.hasAlreadyPlayed < 3) {
            this.happiness += 3;
            if(this.happiness > 50){
                this.happiness = 50;
            }
            this.hasAlreadyPlayed ++;
            System.out.println("You played with your tamagochi");
        } else {
            System.out.println("You played to much with your tamagochi");
        }
    }

    protected void CleanUp(){
        if (isDirty){
            this.isDirty = false;
            System.out.println("The tamagotchi is clean");
        } else{
            System.out.println("LThe tamagotchi is already clean");
        }
    }

    public Boolean Live() {
        if (this.hasEaten == false) {
            this.happiness -= this.hunger ;
            this.hunger += 5;
            if(this.happiness <=0){
                return false;
            }
        } else {
            this.isDirty = true;
        }
        return true;
    };
}
