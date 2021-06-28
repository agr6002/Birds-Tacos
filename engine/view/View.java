package engine.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import engine.App;
import game.Config;

public class View extends JPanel implements Config.View.Itself {

  private static final long serialVersionUID = 1L;

  public App app;
  public Board board;
  public Dimension dimension;
  public int centerX, centerY;

  public View(App app) {
	this.app = app;
	board = new Board(this);
	setBackground(BACKGROUND_COLOR);
  }

  public void handleResize() {
	dimension = getSize();
	centerX = dimension.width / 2;
	centerY = dimension.height / 2;
	board.handleResize(dimension);
  }

  @Override
  public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.translate(centerX, centerY);
	board.paint(g2d);
	g2d.translate(-centerX, -centerY);
	Toolkit.getDefaultToolkit().sync();
	g2d.dispose();
  }

}
