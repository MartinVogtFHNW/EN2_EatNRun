package EatNRun.game_objects;

import gui.Window;

public class Wall extends GameObject {

  public Wall(int x, int y) {
    super(x, y);
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
