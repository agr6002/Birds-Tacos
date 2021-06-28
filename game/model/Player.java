package game.model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import engine.model.Model;
import engine.model.SpriteTranslatable;
import engine.utilities.Vec2;
import game.Config;

public class Player extends SpriteTranslatable implements Config.Player {
	
	public static final Image IMAGE1 = Toolkit.getDefaultToolkit().getImage(IMAGE_SRC_1);
	public static final Image IMAGE2 = Toolkit.getDefaultToolkit().getImage(IMAGE_SRC_2);
	
	  public double dimX = DIM_X;
	  public double dimY = DIM_Y;
	  public int turnDirection = 0;
	  private int row = 0;
	  private int col = 0;
	  public int colMax = 4;
	  public int rowMax = 3;
	  public int dimX_cut = 605;
	  public int dimY_cut = 442;
	  private int flapCount = 0;
	  


  public Player(Model model) {
		super(model, new Vec2(DIM_X, DIM_Y), new Vec2(POS_X, POS_Y), 0, new Vec2(0, 0));
		image = IMAGE1;
	}

  public void turn(int direction) {
	turnDirection = direction;
	if (turnDirection > 0) {
		image = IMAGE1;
	} else if (turnDirection < 0) {
		image = IMAGE2;
	}
  }

public void update() {
	vel.x = SPEED * turnDirection;
	updateModel();
	if (pos.x > model.maxX) {
	  pos.x = model.maxX;
	} else if (pos.x < model.minX) {
	  pos.x = model.minX;
	}
	updateView();
  }

	@Override
	public void paint(Graphics2D g2d) {
		g2d.translate(viewPosX, -viewPosY);// 800 x 638
		g2d.rotate(-posA);
		g2d.drawImage(image, -viewHalfDimX, -viewHalfDimY, viewDimX, viewDimY, dimX_cut * col, dimY_cut * row, dimX_cut * (col + 1), dimY_cut * (row + 1), null);
		g2d.rotate(posA);
		g2d.translate(-viewPosX, viewPosY);
		flapCount++;
		if (!(flapCount % 4 == 0)) {
			return;
		}
		col += 1;
		if (col == colMax) {
			col = 0;
			row += 1;
		}
		if (row == rowMax) {
			row = 0;
		}
	}
}
