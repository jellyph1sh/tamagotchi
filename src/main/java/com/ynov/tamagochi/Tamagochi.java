package com.ynov.tamagochi;

public abstract class Tamagochi {
    protected Boolean hasEaten = false;
    protected Integer lifetime = 0;
    protected Integer happiness = 15;
    private Integer hasAlreadyPlayed = 0;
    protected Integer timeStamp = 1;
    private Integer hunger = 5;
    
    abstract void GrowUp();

    public void Eat() {
        this.hasEaten = true;
        System.out.println("Your tamagochi has eaten");
    };

    public void Play(){
        if (this.hasAlreadyPlayed < 3) {
            this.happiness += 3;
            this.hasAlreadyPlayed ++;
            System.out.println("You played with your tamagochi");
        } else {
            System.out.println("You played to much with your tamagochi");
        }
    }

    public void Live() {
        if (this.hasEaten == false) {
            this.happiness -= this.hunger ;
            this.hunger += 5;
        }
    };
}
