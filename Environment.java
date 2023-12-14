package worldofwonders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Environment {
  protected List<Creature> creatures;
  protected int[][] foodGrid;

public Environment(){
  this.creatures = new ArrayList<>();
  this.foodGrid = new int[150][150];
  initializeFoodGrid();
}

public abstract void createCreature(int xPosition, int yPosition);
public abstract void spawnFood();
public abstract void update();
public abstract void outputStats();
public List<Creature> getCreatures(){
  return creatures;
}

protected void updateCreatures() {
for (Creature creature : creatures) {
  creature.updateHunger();
  creature.die();
  Creature offspring = creature.reproduce();
  if (offspring != null){
    creatures.add(offspring);
  }
  creature.interactWithEnv(this);
  for (Creature otherCreature : creatures){
    if (creature != otherCreature){
      creature.interactWithCreature(otherCreature)
}
}
}

