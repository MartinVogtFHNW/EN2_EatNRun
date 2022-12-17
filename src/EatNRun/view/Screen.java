package EatNRun.view;

import gui.Window;

public class Screen {

  private int screenWith;
  private int screenHeight;
  private String message;

  /**
   * Create new screen with centered message
   * @param screenWith width of game window in pixel
   * @param screenHeight height of game window in pixel
   * @param message message to show on screen
   */
  public Screen(int screenWith, int screenHeight, String message) {
    this.screenWith = screenWith;
    this.screenHeight = screenHeight;
    this.message = message;
  }

  /**
   * Draw screen to window object
   * @param window
   */
  public void draw(Window window) {
    window.setColor(255, 255, 255);
    window.fillRect(0, 0, screenWith, screenHeight);

    window.setColor(0, 0, 0);
    window.setFontSize(50);
    window.drawStringCentered(
      message,
      screenWith / 2,
      screenHeight / 2
    );
  }
}
