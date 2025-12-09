package com.jless.zork;

public class zorkPlayer {
  //declaring local variables to be "used" in the listStats func
  String pName;
  String pClass;
  double health;
  double maxHealth;
  double damage;

  //adding the basis of levelling, super easy to write into a function
  double xp;
  double xpToLevel;
  int level;
  //base levelling func what we plug into a check for xp == xpToLevel in runtime
  public void levelUp() {
    maxHealth = maxHealth + (maxHealth * 1.4);
    damage = damage + (damage * 1.2);
    health = maxHealth;
    xpToLevel = xpToLevel + (xpToLevel * 1.2);
    xp = 0;
  }

  //player constructor to create and store variables taken from app class
  public zorkPlayer(String pName, String pClass, double health, double damage, int xp) {
    this.pName = pName;
    this.pClass = pClass;
    this.health = maxHealth;
    //setting maxHealth to declared value when constructor is made
    //then setting health to that as we will be messing with that separately and it cannot exceed the max
    this.maxHealth = health;
    this.damage = damage;
    this.xp = xp;
  }
  //didnt end up using this but if wanted you can just plug it into the gameplay loop
  public void listPlayerStats() {
    System.out.println("\n==========[Player Stats]===========\nName: " + pName + "\nClass: " + pClass + "\nHealth: " + health + maxHealth + "\nXP: " + xp + xpToLevel + "\nLevel: " + level + "\n===================================");
  }

}
