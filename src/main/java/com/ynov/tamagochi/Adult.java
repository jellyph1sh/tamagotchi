package com.ynov.tamagochi;

public class Adult extends Tamagochi{
    Adult(Integer unitTime, Integer hunger, Integer happiness){
        super(unitTime);
        this.hunger = hunger;
        this.happiness = happiness;
    }
    @Override
    protected void GrowUp(){
        System.out.println("Become a old man!");
    }    
}
