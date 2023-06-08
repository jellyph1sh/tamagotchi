package com.ynov.tamagochi;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Egg extends Tamagochi{ 
  Egg(Integer unitTime){
    super(unitTime);
  }
  @Override
  protected void Eat() {
    System.out.println("Eggs can't eat!");
  };

  @Override
  protected void Play(){
    System.out.println("Eggs can't play!");
  }
  @Override
  protected void CleanUp(){
    System.out.println("Eggs can't take bath!");
  }

  protected Tamagochi GrowUp(){
    System.out.println("Become a little man!");
    return new Child(this.unitTime, this.hunger, this.happiness, this.baseTimestamp, this.lifetime);
  }

  protected void Live() {
    Boolean isGrowing = false;
    Instant instant = Instant.now();
    this.baseTimestamp = instant.toEpochMilli();
    while (isAlive && !isGrowing) {
      instant = Instant.now();
      this.lifetime = instant.toEpochMilli();
      if (((this.lifetime/1000*this.unitTime) - (this.baseTimestamp/1000*this.unitTime)) >= 1) {
        this.GrowUp();
        isGrowing = true;
      }
    }
  }
}