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

public List<Creature> getCreatures(){
  return creatures;
}

}
