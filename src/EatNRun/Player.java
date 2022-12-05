package EatNRun;

import gui.Window;

public class Player extends GameObject {

  private static final int PLAYER_SPEED = 5;

  public Player(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  public void moveUp() {
    super.move(0, -PLAYER_SPEED);
  }

  public void moveDown() {
    super.move(0, PLAYER_SPEED);
  }

  public void moveLeft() {
    super.move(-PLAYER_SPEED, 0);
  }

  public void moveRight() {
    super.move(PLAYER_SPEED, 0);
  }

  @Override
  public void draw(Window window) {
    window.drawImageCentered("resources/images/hero.png", getX(), getY());
  }
}
