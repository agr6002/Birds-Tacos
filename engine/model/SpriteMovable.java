package engine.model;

import engine.utilities.Vec2;
import game.Config;

public abstract class SpriteMovable extends SpriteUpdatable implements Config.Model.Sprite {

  public static final int timeChange = TIMER_INTERVAL;

  public Vec2 vel;
  public double velA;

  public SpriteMovable(Model model, Vec2 dim, Vec2 pos, double posA, Vec2 vel, double velA) {
	super(model, dim, pos, posA);
	this.vel = vel.copy();
	this.velA = velA;
  }

  @Override
  public void updateModel() {
	pos.x += vel.x * timeChange;
	pos.y += vel.y * timeChange;
	posA += velA * timeChange;
  }

  @Override
  public void updateView() {
	viewPosX = (int) Math.round(pos.x * ppu);
	viewPosY = (int) Math.round(pos.y * ppu);
  }

}
