package com.jless.zork;

import java.util.Scanner;

public class App {

  public void runtime() {
    //declaring all our needed stuff for constructors and while loops
    //xp is just there until i write combat
    Scanner scanner = new Scanner(System.in);
    World world = new World();

    //gameplay loop flag
    boolean isPlaying = false;

    String pName = null;
    String pClass = null;

    double health = 0;
    double damage = 0;

    int xpCap = 0;

    //loooots of world reprinting
    world.getWorldState(world.worldState);

    //initialising our code only if it hasnt already been set
    //useful for save games
    //might write that later
    if(pName == null) {

      pName = scanner.nextLine();

      //increasing and re-printing game state
      world.worldState = 1;
      world.getWorldState(world.worldState);

      String choice = scanner.nextLine();

      //a basic if else statement to recieve different inputs
      //each choice is not case sensitive and uses the logical OR symbol
      if(world.worldState == 1) {
        if(choice.contains("1") || choice.toLowerCase().contains("ranger")) {
          pClass = "Ranger";
          damage = 15;
          health = 20;
          xpCap = 85;
        } else if(choice.contains("2") || choice.toLowerCase().contains("fighter")) {
          pClass = "Fighter";
          damage = 20;
          health = 25;
          xpCap = 110;
        } else if(choice.contains("3") || choice.toLowerCase().contains("mage")) {
          pClass = "Mage";
          damage = (int)((Math.random() * (20 - 5)) + 5);
          health = 17;
          xpCap = 70;
        }
      }

      //creating the player object using the constructor
      //rips the variables we decalred earlier and saves them to our player code
      //any code related to players should be kept in their class file
      zorkPlayer zP = new zorkPlayer(pName, pClass, health, damage, xpCap);
      world.zP = zP;

      //we set the playing flag to true to start our main gameplay loop
      //a crucial step for long written stories with a lot of actions
      isPlaying = true;

      world.worldState = 2;

      //this is our main gameplay loop that constantly works through each case item
      //also calling our main switch statement printing the game state using worldState
      //as the switch variable
      //while also pausing for the input, each input is tied to the respective case
      //overall a better method to write inputs instead of what i have above
      while(isPlaying) {
        world.getWorldState(world.worldState);
        String input = scanner.nextLine();
        switch (world.worldState) {
          case 2:
          if(input.toLowerCase().contains("look")) {
            world.worldState = 3;
          } else if(input.toLowerCase().contains("jump")) {
            world.worldState = 4;
          } else if(input.toLowerCase().contains("stats")) {
            zP.listPlayerStats();
          }
          break;
          case 3:
          if(input.toLowerCase().contains("stats")) {
            zP.listPlayerStats();
          }
        }
      }
    }
  }

  //our main arg
  //i like to make separate methods for each of my functions
  //giving me a very modular design that is easy to bugfix
  //and test specific components without needing to rewrite entire columns
  public void main(String[] args) {
    runtime();
  }
}

//we declare a nested class to build our world and progress
class World {

  //here is where we will keep track of the game state for the switch statement
  //we can easliy reference this and securely change it
  //that includes increasing and decreasing it to go back and forward as if you were to change location
  int worldState = 0;

  //we declare zorkPlayer here but dont assign the constructor to keep it unowned by this class
  //we will come back to this later, giving it an object
  zorkPlayer zP;

  //this is what we will use to print the world state,
  //its saved in its own int so we can reference it whenever without issues
  public void getWorldState(int worldState) {
    //hard coding in world states, you can make this more modular by combining strings if certain bools are declared
    String worldState1 =
    "You awaken on a ragged cart bouncing around the old road, passing through a cold damp snow-touched forest.\n" +
    "What will you do? \n\nLook around : Jump off";

    String worldState2 =
    "You look around, catching the eye of a man adorned in battle scarred blue furs.\n" +
    "Before you can let out a word another prisoner sitting across from you pipes up.\n" +
    "Prisoner:'Watch yourself that is Ulfric Stormcloak'\n" +
    "The cart continues to roll and bounce across the cobble road,\n" +
    "a quick look ahead shows a broad stone wall accompanied by a massive wooden door tacked together with broad iron nails and large pine 'planks' which are really dissected trees\n" +
    "This is the end of the playable demo";

    String worldState3 =
    "You jump off the cart breaking into a sprint as soon as your feet hit the ground,\n" +
    "hearing the shout of guards with the muffled laughs of the damned prisoners beind you.\n" +
    "You waste no time tring to get as much distance between you and the soldiers,\n" +
    "praying to the gods you stumble across a band of Stormcloaks\n" +
    "This is the end of the playable demo";

    String combat1 =
    "While running through the thick pine forest, you manage to slip free of the ropes binding your hands.\n" +
    "On your dash to freedom you discover a path of broken branches and sticks leading to a " + zP.pClass + ",\n" +
    "judging by the damp smell and wounds all over his body, there is a beast nearby.\n" +
    "Without hesitating you liberate the sword and shield from the poor man just as a dire wolf emerges from the bush.\n" +
    "\nCombat Initiated:\n";

    //where we control the world state and print out the cases
    switch(worldState) {
      case 0 -> System.out.println("You can look at character stats by typing Stats into the console. \nPlease enter character name: ");

      case 1 -> System.out.println("Please pick a class  : \n1.Ranger \n2.Fighter \n3.Mage");

      case 2 -> System.out.println(worldState1);

      case 3 -> System.out.println(worldState2);

      case 4 -> System.out.println(worldState3);

      case 5 -> System.out.println(combat1);
    }
  }
}
