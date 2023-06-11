package com.ynov.tamagochi;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import com.ynov.UI.Menu;

public class Egg extends Tamagochi{ 
  public Egg(long unitTime) {
    super(unitTime);
    this.status = "egg";
  }

  @Override
  public void Eat() {
    System.out.println("Eggs can't eat!");
  };
  @Override
  public void Play(){
    System.out.println("Eggs can't play!");
  }
  @Override
  public void CleanUp(){
    System.out.println("Eggs can't take bath!");
  }

  protected Tamagochi GrowUp(){
    System.out.println("Become a little man!");
    return new Child(this.unitTime, this.hunger, this.happiness);
  }

  public Tamagochi Live()  {
    return this.GrowUp();
  }
}