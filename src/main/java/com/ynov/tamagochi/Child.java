package com.ynov.tamagochi;

public class Child extends Tamagochi{
    Child(Integer unitTime, Integer hunger, Integer happiness){
        super(unitTime);
        this.hunger = hunger;
        this.happiness = happiness;
    }
    @Override
    protected void GrowUp(){
        System.out.println("Become a real man");
    }
}
