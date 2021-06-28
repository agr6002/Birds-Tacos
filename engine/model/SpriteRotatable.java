package engine.model;

import engine.utilities.Vec2;
import game.Config;

public abstract class SpriteRotatable extends SpriteUpdatable implements Config.Model.Sprite {

  public static final int timeChange = TIMER_INTERVAL;

  public double velA;

  public SpriteRotatable(Model model, Vec2 dim, Vec2 pos, double posA, double velA) {
	super(model, dim, pos, posA);
	this.velA = velA;
  }

  @Override
  public void updateModel() {
	posA += velA * timeChange;
  }

  @Override
  public void updateView() {
  }
}
