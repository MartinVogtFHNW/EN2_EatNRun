package EatNRun;

import gui.Window;

public class Monster extends GameObject {

  private static final int PLAYER_SPEED = 5;

  public Monster(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Window window) {
    window.drawImageCentered("resources/images/Monster.png", getX(), getY());
  }
}
