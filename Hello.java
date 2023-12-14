package worldofwonders;

import java.util.Random;

public class Hello {
  public static void main(String[] args) {
    Environment world = new World(0.5);

    for(int i = 0; i < 100; i++){
      world.createCreature();
      world.spawnFood();
      world.update();
      world.outputStats();
    }
  }
  private static int getRandomPosition(){
    return (int) (Math.random()*150);
  }
}
