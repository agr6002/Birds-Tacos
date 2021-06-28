package game.model;

import java.awt.Image;
import java.awt.Toolkit;

import engine.model.Model;
import engine.model.Sprite;
import engine.utilities.Vec2;
import game.Config;

public class Background extends Sprite implements Config.Background {

	public static final Image IMAGE = Toolkit.getDefaultToolkit().getImage(IMAGE_SRC);

	public Background(Model model) {
		super(model, new Vec2(DIM_X, DIM_Y), new Vec2(POS_X, POS_Y), 0);
		image = IMAGE;
	}

}
