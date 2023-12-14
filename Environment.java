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
  List<Creature> newOffspring = new ArrayList<>();
  for (Creature creature : creatures) {
      creature.updateHunger();
      creature.die();
      Creature offspring = creature.reproduce();
      if (offspring != null){
        newOffspring.add(offspring);
  }
    creature.interactWithEnvironment(this);
    for (Creature otherCreature : creatures){
      if (creature != otherCreature){
        creature.interactWithCreature(otherCreature);
    }
  }
}
  creatures.addAll(newOffspring);
  this.outputStats();
}

protected void initializeFoodGrid() {
  Random random = new Random();
  for (int i = 0; i < foodGrid.length; i++){
    for (int j = 0; j < foodGrid[i].length; j++){
      foodGrid[i][j] = random.nextInt(10);
    }
  }
}

public int getFoodAtPosition(int x, int y){
  return foodGrid[x][y];
}

public void decreaseFoodAtPosition(int x, int y, int amount) {
  if (foodGrid[x][y] - amount >= 0){
    foodGrid[x][y] -= amount;
  } else {
    foodGrid[x][y] = 0;
    }
  }
}

