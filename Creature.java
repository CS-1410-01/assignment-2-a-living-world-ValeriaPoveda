package worldofwonders;

public class Creature implements LivingBeing {
  private String name;
  private double replicationChance;
  private double deathChance;

public Creature(String name, double replicationChance, double deathChance)
  this.name = name;
  this.replicationChance = replicationChance;
  this.deathChance = deathChance;
}
@Override
public void die(){
}

@Override
public Creature reproduce (){
  return null;
}


