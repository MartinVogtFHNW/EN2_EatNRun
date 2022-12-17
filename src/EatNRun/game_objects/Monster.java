package EatNRun.game_objects;

import gui.Window;

public class Monster extends GameObject {

  private int vx;
  private int vy;

  public Monster(int x, int y, int vx, int vy) {
    super(x, y);
    this.vx = vx;
    this.vy = vy;
  }

  /**
   * Change move direction by 180°
   */
  public void bounceOfWall() {
    this.vx *= -1;
    this.vy *= -1;
  }

  /**
   * Moves object by vx and vy value
   */
  public void move() {
    setX(getX() + vx);
    setY(getY() + vy);
  }

  @Override
  public void draw(Window window) {
    window.drawImageCentered("resources/images/Monster.png", getX(), getY());
  }
}
