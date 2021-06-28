package engine.model;

import java.util.ArrayList;

import engine.App;
import engine.utilities.Vec2;
import game.Config;
import game.model.Background;
import game.model.Player;
import game.model.Taco;

public class Model implements Config.Model.Itself {

  public App app;
  public ArrayList<Taco> tacos = new ArrayList<>();
  public Player player;
  public Background background;
  public double maxX = MAX_X;
  public double minX = MIN_Y;
  public double maxY = MAX_Y;
  public double minY = MIN_Y;
  public double width = MAX_X - MIN_X;
  public double height = MAX_Y - MIN_Y;

  public Model(App app) {
	this.app = app;
	initializePlayer();
	initializeTacos();
	initializeBackground();
  }

  private void initializePlayer() {
	player = new Player(this);
  }
  
  private void initializeTacos() {
	  for (int i =0; i < 15; i++) {
		  tacos.add(new Taco(this, new Vec2(-50 + 100 * Math.random(), 50 + 100 * Math.random())));
	  }
  }
  
  private void initializeBackground() {
		background = new Background(this);
  }

  public void update() {
	player.update();
//	System.out.println("running");
	for (Taco taco : tacos) {
		if (
				player.pos.x < taco.pos.x + taco.dimX
				&& player.pos.x + player.dimX > taco.pos.x
				&& player.pos.y < taco.pos.y + taco.dimY
				&& player.pos.y + player.dimY > taco.pos.y 
			) { 
			System.out.print("test");
			taco.collide();
		}
	  taco.update();
	}
	
  }

}
