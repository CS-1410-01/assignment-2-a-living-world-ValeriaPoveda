package worldofwonders;

import java.util.Random;

public class World extends Environment {
  private double creatureSpawnChance;

  public World (double creatureSpawnChance){
    super();
    this.creatureSpawnChance = creatureSpawnChance;
  }

  @Override
   public void createCreature(){
     if (Math.random() < creatureSpawnChance) {
       Creature newCreature = new Creature(Name.Generator.getRandomeName(), 0.5, 0.2);
       creatures.add(newCreature);
     }
   }

  @Override
  public void spawnFood(){
  }
}

  
  

