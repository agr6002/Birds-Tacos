package engine.utilities;

public class Vec2 {

  public double x, y;

  public Vec2(double x, double y) {
	this.x = x;
	this.y = y;
  }

  public Vec2 copy() {
	return new Vec2(x, y);
  }

}
