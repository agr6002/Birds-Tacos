package engine.model;

import engine.utilities.Vec2;

public abstract class SpriteRotAccelerable extends SpriteRotatable {

  public static final int timeChange = TIMER_INTERVAL;

  public double accA;

  public SpriteRotAccelerable(Model model, Vec2 dim, Vec2 pos, double posA, double velA, double accA) {
	super(model, dim, pos, posA, velA);
	this.accA = accA;
  }

  @Override
  public void updateModel() {
	velA += accA * timeChange;
	posA += velA * timeChange;
  }
}
