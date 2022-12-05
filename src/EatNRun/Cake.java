package EatNRun;

import gui.Window;

public class Cake extends GameObject {

  Cake(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Window window) {
    window.drawImageCentered("resources/images/cake.png", getX(), getY());
  }
}
