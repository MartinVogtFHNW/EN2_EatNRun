package EatNRun;

import java.util.ArrayList;

import gui.Window;

public class Player extends GameObject {

  private static final int PLAYER_HEIGHT = 30;
  private static final int PLAYER_WIDTH = 20;
  private static final int SPEED = 5;
  private int startX;
  private int startY;

  public Player(int x, int y) {
    super(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
    this.startX = x;
    this.startY = y;
  }

  public void resetToStart() {
    setX(startX);
    setY(startY);
  }

  public void moveUp() {
    super.move(0, -SPEED);
  }

  public void moveDown() {
    super.move(0, SPEED);
  }

  public void moveLeft() {
    super.move(-SPEED, 0);
  }

  public void moveRight() {
    super.move(SPEED, 0);
  }

  @Override
  public void draw(Window window) {
    window.drawImageCentered("resources/images/hero.png", getX(), getY());
  }
}
