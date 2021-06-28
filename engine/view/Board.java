package engine.view;

import java.awt.Dimension;
import java.awt.Graphics2D;

import game.Config;
//import game.model.Frog;
import game.model.Taco;

public class Board implements Config.View.Board {

  private Dimension dimension = new Dimension(0, 0);
  public View view;
  public double ppu = 0;

  public Board(View view) {
	this.view = view;
  }

  public void handleResize(Dimension dimension) {
	int width = Math.min(dimension.width, (int) Math.round(dimension.height * ASPECT_RATIO));
	int height = Math.min(dimension.height, (int) Math.round(dimension.width / ASPECT_RATIO));
	this.dimension.setSize(width, height);
	ppu = width / view.app.model.width;
	for (Taco taco : view.app.model.tacos) {
		  taco.resize(ppu);
		}
	view.app.model.player.resize(ppu);
	//System.out.println(view.app.model.background);
	view.app.model.background.resize(ppu);
  }

  public void paint(Graphics2D g2d) {
	 view.app.model.background.paint(g2d);
	for (Taco taco : view.app.model.tacos) {
		  taco.paint(g2d);
		}
	view.app.model.player.paint(g2d);
  }

}
