package engine.model;

import engine.utilities.Vec2;

public abstract class SpriteAccelerable extends SpriteMovable {

  public static final int timeChange = TIMER_INTERVAL;

  public Vec2 acc;
  public double accA;

  public SpriteAccelerable(Model model, Vec2 dim, Vec2 pos, double posA, Vec2 vel, double velA, Vec2 acc, double accA) {
	super(model, dim, pos, posA, vel, velA);
	this.acc = acc.copy();
	this.accA = accA;
  }

  @Override
  public void updateModel() {
	vel.x += acc.x * timeChange;
	vel.y += acc.y * timeChange;
	velA += accA * timeChange;
	pos.x += vel.x * timeChange;
	pos.y += vel.y * timeChange;
	posA += velA * timeChange;
  }

}
