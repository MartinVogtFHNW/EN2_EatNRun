package EatNRun.view;

import gui.Window;

public class Score {

  public static int OFFSET_TOP = 30;

  /**
   * Display game score centered on top
   * @param window
   * @param screenWith width of game window in pixel
   * @param playerCakes number of cakes player has
   * @param playerLives number of lives player has
   * @param currentLevel current level
   */
  public static void draw(
    Window window,
    int screenWith,
    int playerCakes,
    int playerLives,
    int currentLevel
  ) {
    window.setBold(true);
    window.setColor(255, 255, 255);
    window.setFontSize(25);
    window.drawStringCentered(
      "Cakes: " +
      playerCakes +
      " Lives: " +
      playerLives +
      " Level: " +
      currentLevel,
      screenWith / 2,
      OFFSET_TOP
    );
  }
}
