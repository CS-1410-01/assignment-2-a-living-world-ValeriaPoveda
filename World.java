public class World {
  private List<Creature> creatures;
  private double creatureSpawnChance;

  public World (double creatureSpawnChance){
    this.creatures = new ArrayList<>();
    this.creatureSpawnChance = creatureSpawnChance;
  }
   public void createCreature(){
     if (Math.random() < creatureSpawnChance) {
       Creature newCreature = new Creature(Name.Generator.getRandomeName(), 0.5, 0.2);
       creatures.add(newCreature);
     }
   }
  public void spawnFood(){
  }
}

  
  

