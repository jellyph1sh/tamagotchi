package com.ynov.tamagochi;

import java.util.Random;

public class OldMan extends Tamagochi{
    protected Boolean isSick = false;
    OldMan(Integer unitTime){
        super(unitTime);
    }
    @Override
    protected void GrowUp(){
        System.out.println("Die");
    }    

    protected void Heal(){
        if (isSick){
            this.isSick = false;
            System.out.println("Old tamagotchi is no longer ill");
        } else{
            System.out.println("Old tamagotchi isn't sick");
        }
    }

    @Override
    public Boolean Live(){
        super.Live();
        if (isSick){
            return false;
        }
        Random rand = new Random();
        int randomNumber = rand.nextInt(2);
        if (randomNumber == 0){
            this.isSick = true;
        }
        return true;
    }
}
