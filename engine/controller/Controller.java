package engine.controller;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import engine.App;

public class Controller implements KeyListener, MouseListener, ComponentListener {

  public App app;
  private int requestedTurn = 1;

  public Controller(App app) {
	this.app = app;
  }

  @Override
  public void componentHidden(ComponentEvent arg0) {
	// TODO Auto-generated method stub

  }

  @Override
  public void componentMoved(ComponentEvent arg0) {
	// TODO Auto-generated method stub

  }

  @Override
  public void componentResized(ComponentEvent e) {
	app.view.handleResize();
  }

  @Override
  public void componentShown(ComponentEvent arg0) {
	// TODO Auto-generated method stub

  }

  @Override
  public void keyPressed(KeyEvent e) {
	switch (e.getKeyCode()) {
	case KeyEvent.VK_ESCAPE:
	  app.toggleFullScreen();
	  break;
	case KeyEvent.VK_LEFT:
	  if (requestedTurn == -1) {
		return;
	  }
	  requestedTurn = -1;
	  app.model.player.turn(-1);
	  break;
	case KeyEvent.VK_RIGHT:
	  if (requestedTurn == 1) {
		return;
	  }
	  requestedTurn = 1;
	  app.model.player.turn(1);
	  break;
	}
  }

  @Override
  public void keyReleased(KeyEvent e) {
	switch (e.getKeyCode()) {
	case KeyEvent.VK_LEFT:
	  if (requestedTurn != -1) {
		return;
	  }
	  requestedTurn = 0;
	  app.model.player.turn(0);
	  break;
	case KeyEvent.VK_RIGHT:
	  if (requestedTurn != 1) {
		return;
	  }
	  requestedTurn = 0;
	  app.model.player.turn(0);
	  break;
	}
  }

  @Override
  public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub

  }

  @Override
  public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub

  }

  @Override
  public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub

  }

}
