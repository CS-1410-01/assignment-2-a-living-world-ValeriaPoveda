package worldofwonders;

public class World extends Environment {
  private int foodAvailability;

  public World (double initialFood) {
    super();
    this.foodAvailability = (int) (initialFood * 100);
  }

  @Override 
  public void createCreature() {
    creatures.add(new Creature (NameGenerator.getRandomName(), 0.1, 0.1));
  }

  @Override
  public void spawnFood() {
    this.foodAvailability += 10;
  }

  @Override public void update() {
    for (Creature creature : creatures) {
      creature.updateHunger();
      creature.die();
      Creature offspring = creature.reproduce();
      if (offspring != null) {
        creatures.add(offspring);
      }
    }
    this.outputStats();
  }

  @Override
  public void outputStats(){
    System.out.println("Population: " + creatures.size());
    System.out.println("Food Availability: " + foodAvailability);
  }
}
  

  
  

