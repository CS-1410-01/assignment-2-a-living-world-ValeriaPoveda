package worldofwonders;

public interface LivingBeing {
  void die();
  Creature reproduce();
  void interactWithEnvironment(Environment environment);
  void interactWithCreature(Creature otherCreature);
}
