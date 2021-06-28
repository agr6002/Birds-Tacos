package engine.model;

import engine.utilities.Vec2;

public abstract class SpriteTransAccelerable extends SpriteTranslatable {

  public static final int timeChange = TIMER_INTERVAL;

  public Vec2 acc;

  public SpriteTransAccelerable(Model model, Vec2 dim, Vec2 pos, double posA, Vec2 vel, Vec2 acc) {
	super(model, dim, pos, posA, vel);
	this.acc = acc.copy();
  }

  @Override
  public void updateModel() {
	vel.x += acc.x * timeChange;
	vel.y += acc.y * timeChange;
	pos.x += vel.x * timeChange;
	pos.y += vel.y * timeChange;
  }
}
