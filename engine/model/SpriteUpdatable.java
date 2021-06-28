package engine.model;

import engine.utilities.Vec2;

public abstract class SpriteUpdatable extends Sprite {

  public SpriteUpdatable(Model model, Vec2 dim, Vec2 pos, double posA) {
	super(model, dim, pos, posA);
  }

  public abstract void updateModel();

  public abstract void updateView();

}
