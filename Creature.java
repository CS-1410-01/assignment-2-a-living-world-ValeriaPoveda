package worldofwonders;

public class Creature implements LivingBeing {
  private String name;
  private double replicationChance;
  private double deathChance;
  private int hunger;
  private int xPosition;
  private int yPosition;

public Creature(String name, double replicationChance, double deathChance, int xPosition, int yPosition){
  this.name = name;
  this.replicationChance = replicationChance;
  this.deathChance = deathChance;
  this.hunger = 50;
  this.xPosition = xPosition;
  this.yPosition = yPosition;
}
  
public void move(int newX, int newY) {
  this.xPosition = newX;
  this.yPosition = newY;
  }

public void interactWithEnvironment(World world){
  int food = world.getFoodAtPosition(xPosition, yPosition);
  if (food > 0){
    eatFood(world, food);
  }
}

public void interactWithCreature(Creature otherCreature){
}

private void eatFood(World world, int food){
  decreaseHunger(food*3);
  world.decreaseFoodAtPosition(xPosition, yPosition, food);
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
    return new Creature(NameGenerator.getRandomName(), replicationChance, deathChance, xPosition, yPosition);
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
}
