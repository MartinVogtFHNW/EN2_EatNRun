package EatNRun.game_objects;

import gui.Window;

public class Finish extends GameObject {

  public Finish(int x, int y) {
    super(x, y);
  }

  @Override
  public void draw(Window window) {
    window.drawImageCentered("resources/images/finish.png", getX(), getY());
  }
}
