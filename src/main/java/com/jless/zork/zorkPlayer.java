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
  double xpOverflow;
  double xpToLevel;
  int level;

  //levelling func what we plug into a check for xp >= xpToLevel in runtime
  public void levelUp() {
    maxHealth = maxHealth + (maxHealth * 1.4);
    damage = damage + (damage * 1.2);
    health = maxHealth;

    //this is a check to see if you got more than needed and puts it into xp so it doesnt get wiped
    //and if you have less we take out the overflow just incase it borks xp into the negative
    if(xp > xpToLevel) {
      xpOverflow = xp - xpToLevel;
      xpToLevel = xpToLevel + (xpToLevel * 1.2);
      xp = xpOverflow;
    } else {
      xpToLevel = xpToLevel + (xpToLevel * 1.2);
      xp = 0;
    }
  }

  //player constructor to create and store variables taken from app class
  public zorkPlayer(String pName, String pClass, double health, double damage, int xp) {
    this.pName = pName;
    this.pClass = pClass;

    //setting maxHealth to declared value when constructor is made
    //then setting health to that as we will be messing with that separately and it cannot exceed the max
    this.maxHealth = health;
    this.health = this.maxHealth;
    this.damage = damage;
    this.xpToLevel = xp;
  }
  //ended up using this after all to call a stat print
  public void listPlayerStats() {
    String playerStats =
    "\n=======[Player Stats]========" +
    "\nName:    " + pName +
    "\nClass:   " + pClass +
    "\nHealth:  " + health + "/" + maxHealth +
    "\nLevel:   " + level +
    "\nXP:      " + xp + "/" + xpToLevel +
    "\n=============================\n";

    System.out.println(playerStats);
  }

}
class zorkWolf {
  double wolfHealth;
  int wolfDamage;
  int xpGiven = 150;

  public zorkWolf(double health, int damage) {

  }
}
