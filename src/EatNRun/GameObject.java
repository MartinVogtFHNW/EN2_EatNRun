package EatNRun;

import gui.Window;

public abstract class GameObject {

  private int x;
  private int y;
  private int width;
  private int height;

  public GameObject(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  /**
   * Moves object by dx and dy value
   *
   * @param dx the amout of pixel in x direction
   * @param dy the amout of pixel in y direction
   */
  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  /**
   * Draws object to window
   */
  public void draw(Window window) {
    window.setColor(255, 0, 0);
    window.drawRect(x - width / 2, y - height / 2, width, height);
  }

  /**
   * Checks if objects intersects given object
   * @return true or false on intersect
   */
  public boolean intersects(GameObject other) {
    return (
      x - width / 2 < other.x + other.width / 2 &&
      x + width / 2 > other.x - other.width / 2 &&
      y - height / 2 < other.y + other.height / 2 &&
      y + height / 2 > other.y - other.height / 2
    );
  }
}
