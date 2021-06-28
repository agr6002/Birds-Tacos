package engine.model;

import engine.utilities.Vec2;

public abstract class SpriteStatic extends Sprite {

  public Vec2 del;
  public double delA;

  public SpriteStatic(Model model, Vec2 dim, Vec2 pos, double posA, Vec2 del, double delA) {
	super(model, dim, pos, posA);
	this.del = del.copy();
	this.delA = delA;
  }

  public void updateModel(int chX, int chY, int chA) {
	pos.x += chX * del.x;
	pos.y += chY * del.y;
	posA += chA * delA;
  }

  public void updateView() {
	viewPosX = (int) Math.round(pos.x * ppu);
	viewPosY = (int) Math.round(pos.y * ppu);
  }
}
