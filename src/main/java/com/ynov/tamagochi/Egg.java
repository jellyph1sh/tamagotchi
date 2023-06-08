package com.ynov.tamagochi;

public class Egg extends Tamagochi{ 
  Egg(Integer unitTime){
    super(unitTime);
  }
  @Override
  protected void Eat() {
    System.out.println("Eggs doesn't eat");
  };

  @Override
  protected void Play(){
    System.out.println("Eggs can't play");
  }
  @Override
  protected void CleanUp(){
    System.out.println("Eggs can't take bath");
  }

  protected void GrowUp(){
    // make a tammagautchy child
    System.out.println("Become a little man");
  }
}