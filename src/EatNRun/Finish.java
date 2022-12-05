package EatNRun;

import gui.Window;

public class Finish extends GameObject {

  Finish(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Window window) {
    window.drawImageCentered("resources/images/finish.png", getX(), getY());
  }
}
