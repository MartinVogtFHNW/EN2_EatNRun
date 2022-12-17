package EatNRun.game_objects;

import gui.Window;

public class Cake extends GameObject {

  public Cake(int x, int y) {
    super(x, y);
  }

  @Override
  public void draw(Window window) {
    window.drawImageCentered("resources/images/cake.png", getX(), getY());
  }
}
