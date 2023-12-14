package worldofwonders;

import java.itl.Random;

public class World extends Environment {
  public World() {
    super();
  }

  @Override 
  public void createCreature(int xPosition, int yPosition) {
    creatures.add(new Creature (NameGenerator.getRandomName(), 0.1, 0.1, xPosition, yPosition));
  }

  @Override
  public void spawnFood() {
    Random random = new Random();
    int x = random.nextInt(foodGrid.length);
    int y = random.nextInt(foodGrid[0].length);
    foodGrid[x][y] += 10;
  }

  @Override 
  public void update() {
    for (Creature creature : creatures) {
     int newX = creature.xPosition + getRandomMovement();
     int newY = creature.yPosition + getRandomMovement();
     newX = Math.max(0, Math.min(newX, foodGrid.length - 1));
     newY = Math.max(0, Math.min(newY, foodGrid[0].length - 1));
      creature.move(newX, newY);
    }
    updateCreatures();
  }

  private int getRandomMovement(){
    Random random = new Random();
    return random.nextInt(3) -1;
  }
 
  @Override
  public void outputStats(){
    System.out.println("Population: " + creatures.size());
  }
}
  

  
  

