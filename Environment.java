package worldofwonders;

import java.util.ArrayList;
import java.util.List;

public abstract class Environment {
  protected List<Creature> creatures;

public Environment(){
  this.creatures = new ArrayList<>();
}

public abstract void createCreature();
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
}
  public void outputStats() {
    System.out.println("Number of creatures: " + creatures.size());
}
}
}
