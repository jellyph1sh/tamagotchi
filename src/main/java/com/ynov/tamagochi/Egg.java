package com.ynov.tamagochi;

import java.time.Instant;

public class Egg extends Tamagochi{ 
  public Egg(Integer unitTime) {
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
    return new Child(this.unitTime, this.hunger, this.happiness);
  }

  protected void Live() {
    Boolean isGrowing = false;
    this.baseTimestamp = Instant.now().toEpochMilli();
    while (isAlive && !isGrowing) {
      this.lifetime = Instant.now().toEpochMilli();
      if (((this.lifetime/1000*this.unitTime) - (this.baseTimestamp/1000*this.unitTime)) >= 1) {
        this.GrowUp();
        isGrowing = true;
      }
    }
  }
}