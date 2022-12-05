package EatNRun;

import gui.Window;

public class Wall extends GameObject {

  Wall(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Window window) {
    window.setColor(0, 0, 0);
    window.fillRect(
      getX() - getWidth() / 2,
      getY() - getHeight() / 2,
      getWidth(),
      getHeight()
    );
  }
}
