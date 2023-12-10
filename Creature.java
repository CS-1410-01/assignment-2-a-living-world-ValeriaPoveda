package worldofwonders;

public class Creature implements LivingBeing {
  private String name;
  private double replicationChance;
  private double deathChance;
  private int hunger;

public Creature(String name, double replicationChance, double deathChance){
  this.name = name;
  this.replicationChance = replicationChance;
  this.deathChance = deathChance;
  this.hunger = 50;
}
@Override
public void die(){
  if (isDead() || isStarving()){
    System.out.println(this.name + " has died.");
  }
}

@Override
public Creature reproduce (){
  if (Math.random() < replicationChance) {
    System.out.println(this.name + " has reproduced.");
    return new Creature(NameGenerator.getRandomName(), replicationChance, deathChance);
  }
  return null;
}

  public void run() {
    increaseHunger(5);
    System.out.println(this.name + " is running. Hunger level increased. ");
  }

  public void eat() {
    decreaseHunger(7);
    System.out.println(this.name + " is eating. Hunger level decreased. ");
  }
  
  public void updateHunger(){
    System.out.println(this.name + " 's hunger level; " + this.hunger);
    die();
  }

  private boolean isDead() {
    return Math.random() < deathChance;
  }

  private boolean isStarving() {
    return this.hunger >= 70;
  }

  private void increaseHunger(int amount){
    this.hunger += amount;
  }

  private void decreaseHunger(int amount){
    if (this.hunger - amount >= 0) {
        this.hunger -= amount;
  } else {
    this.hunger = 0;
  }
}
