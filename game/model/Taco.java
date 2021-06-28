//package game.model;
//
//public class Taco {
//
//}
package game.model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import engine.model.Model;
import engine.model.SpriteTransAccelerable;
import engine.utilities.Vec2;
import game.Config;

public class Taco extends SpriteTransAccelerable implements Config.Taco {

  public static final Image IMAGE_1 = Toolkit.getDefaultToolkit().getImage(IMAGE_SRC_1);
  public static final Image IMAGE_2 = Toolkit.getDefaultToolkit().getImage(IMAGE_SRC_2);
  public static final double gravity = -0.00001;
  public double dimX = DIM_X;
  public double dimY = DIM_Y;
  private int row = 0;
  private int col = 0;
  public int colMax = 3;
  public int rowMax = 3;
  public int dimX_cut = 800;
  public int dimY_cut = 638;
  private int explodeCount = 0;
		  
  public Taco(Model model, Vec2 pos) {
	super(model, new Vec2(DIM_X, DIM_Y), pos, 0, new Vec2(-0.05 + 0.1 * Math.random(), -SPEED), new Vec2(0, gravity));
	image = IMAGE_1;
  }

  public void update() {
	updateModel();
	
	if (pos.x > model.maxX) {
	  pos.x = model.maxX;
	  vel.x *= -1;
	} else if (pos.x < model.minX) {
	  pos.x = model.minX;
	  vel.x *= -1;
	}
	if (pos.y < model.minY) {
		over();
	}
	updateView();
  }
  
  public void collide() {
	  image = IMAGE_2;
  }
  
  private void over() {
	  vel.y = 0;
	  vel.x = -0.05 + 0.1 * Math.random();
	  pos.y = model.maxY + 100 * Math.random();
	  pos.x = -50 + 100 * Math.random();
	  image = IMAGE_1;
  }
  
  @Override
	public void paint(Graphics2D g2d) {
	  	if (image == IMAGE_1) {
	  		g2d.translate(viewPosX, -viewPosY);
	  		g2d.rotate(-posA);
	  		g2d.drawImage(image, -viewHalfDimX, -viewHalfDimY, viewDimX, viewDimY, null);
	  		g2d.rotate(posA);
	  		g2d.translate(-viewPosX, viewPosY);
	  		
	  	} else {
			g2d.translate(viewPosX, -viewPosY);// 800 x 638
			g2d.rotate(-posA);
			g2d.drawImage(image, -viewHalfDimX, -viewHalfDimY, viewDimX, viewDimY, dimX_cut * col, dimY_cut * row, dimX_cut * (col + 1), dimY_cut * (row + 1), null);
			g2d.rotate(posA);
			g2d.translate(-viewPosX, viewPosY);
			explodeCount++;
			if (!(explodeCount % 4 == 0)) {
				return;
			}
			col += 1;
			if (col == colMax) {
				col = 0;
				row += 1;
			}
			if (row == rowMax) {
				over();
			}
		}
  }

}
