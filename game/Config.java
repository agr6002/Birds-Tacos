package game;

import java.awt.Color;
import java.awt.Dimension;

public interface Config {

  interface App {

	final boolean HAS_KEY_CONTROLS = true;
	final boolean HAS_MOUSE_CONTROLS = true;
	final boolean IS_FULL_SCREEN = true;
	final boolean IS_RESIZABLE = true;
	final int PREFERRED_HEIGHT = 600;
	final int PREFERRED_WIDTH = 600;
	final Dimension PREFERRED_SIZE = new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
	final int TIMER_INTERVAL = 17;
	final String TITLE = "Game Engine";

  }

  interface Controller {

  }

  interface Model {

	interface Itself {

	  final double MIN_X = -50.0;
	  final double MAX_X = 50.0;
	  final double MIN_Y = -50.0;
	  final double MAX_Y = 50.0;
	  final int NUM_FROGS = 4;

	}

	interface Sprite {

	  final int TIMER_INTERVAL = App.TIMER_INTERVAL;

	}

  }

  interface View {

	interface Itself {

	  final Color BACKGROUND_COLOR = Color.gray;

	}

	interface Board {

	  final Color BACKGROUND_COLOR = Color.black;
	  // ASPECT_RATIO = ratio of board's width to board's height
	  final double ASPECT_RATIO = (Model.Itself.MAX_X - Model.Itself.MIN_X) / (Model.Itself.MAX_Y - Model.Itself.MIN_Y);

	}
  }

  interface Taco {

		final double DIM_X = 13 + 1.0 / 3;
		final double DIM_Y = 10.0;
		final double SPEED = 0.01;
		final String IMAGE_SRC_1 = "src/game/resources/taco-2.png";
		final String IMAGE_SRC_2 = "src/game/resources/explosionSpriteSheet.png";

  }
  
  interface Player {

	final double DIM_X = 17.25;
	final double DIM_Y = 7.5;
	final double POS_X = 0;
	final double POS_Y = -25;
	final double SPEED = 0.01;
	final String IMAGE_SRC_1 = "src/game/resources/birdSpriteSheet.png";
	final String IMAGE_SRC_2 = "src/game/resources/birdSpriteSheetB.png";
  }
  
  interface Background {
	  final double DIM_X = Model.Itself.MAX_X - Model.Itself.MIN_X;
	  final double DIM_Y = Model.Itself.MAX_Y - Model.Itself.MIN_Y;
	  final double POS_X = 0;
	  final double POS_Y = 0;
	  final String IMAGE_SRC = "src/game/resources/background.jpg";
  }

}
