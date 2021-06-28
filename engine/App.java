package engine;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import engine.controller.Controller;
import engine.model.Model;
import engine.view.View;
import game.Config;

public class App extends JFrame implements ActionListener, Config.App {

  private static final long serialVersionUID = 1L;
  private static final GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment()
	  .getDefaultScreenDevice();
  private static final boolean isFullScreenSupported = graphicsDevice.isFullScreenSupported();

  public boolean isFullScreen = false;
  public Controller controller;
  public Model model;
  public View view;
  private Timer timer;

  public App() {
	controller = new Controller(this);
	model = new Model(this);
	view = new View(this);
	timer = new Timer(TIMER_INTERVAL, this);

	add(view);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(PREFERRED_SIZE);
	setLocationRelativeTo(null);
	setTitle(TITLE);
	if (IS_RESIZABLE) {
	  addComponentListener(controller);
	  setResizable(true);
	} else {
	  setResizable(false);
	}
	if (HAS_MOUSE_CONTROLS) {
	  addMouseListener(controller);
	}
	if (HAS_KEY_CONTROLS) {
	  addKeyListener(controller);
	}
	if (IS_FULL_SCREEN) {
	  toggleFullScreen();
	}
	setVisible(true);
	timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
	model.update();
	view.repaint();
  }

  public void toggleFullScreen() {
	if (!isFullScreenSupported) {
	  return;
	}
	isFullScreen = !isFullScreen;
	setVisible(false);
	dispose();
	setUndecorated(isFullScreen);
	if (isFullScreen) {
	  graphicsDevice.setFullScreenWindow(this);
	  validate();
	} else {
	  graphicsDevice.setFullScreenWindow(null);
	  setVisible(true);
	}
  }

}
