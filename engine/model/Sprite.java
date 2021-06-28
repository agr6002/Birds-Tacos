package engine.model;

import java.awt.Graphics2D;
import java.awt.Image;

import engine.utilities.Vec2;

public abstract class Sprite {

  public Vec2 dim, halfDim, pos;
  public int viewDimX, viewDimY, viewHalfDimX, viewHalfDimY, viewPosX, viewPosY;
  public double posA;
  public double ppu;
  public Image image;
  public Model model;

  public Sprite(Model model, Vec2 dim, Vec2 pos, double posA) {
	this.model = model;
	this.dim = dim.copy();
	this.halfDim = new Vec2(0.5 * dim.x, 0.5 * dim.y);
	this.pos = pos.copy();
	this.posA = posA;
  }

  public void paint(Graphics2D g2d) {
	g2d.translate(viewPosX, -viewPosY);
	g2d.rotate(-posA);
	g2d.drawImage(image, -viewHalfDimX, -viewHalfDimY, viewDimX, viewDimY, null);
	g2d.rotate(posA);
	g2d.translate(-viewPosX, viewPosY);
  }

  public void resize(double ppu) {
	this.ppu = ppu;
	viewDimX = (int) Math.round(dim.x * ppu);
	viewDimY = (int) Math.round(dim.y * ppu);
	viewHalfDimX = (int) Math.round(halfDim.x * ppu);
	viewHalfDimY = (int) Math.round(halfDim.y * ppu);
	viewPosX = (int) Math.round(pos.x * ppu);
	viewPosY = (int) Math.round(pos.y * ppu);
  }

}
