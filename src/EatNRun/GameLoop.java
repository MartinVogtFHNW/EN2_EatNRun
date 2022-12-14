package EatNRun;

import gui.Window;

public class GameLoop {

  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;
  private static final int CLEAR_SCREEN_TIME_MS = 20;

  public static void main(String[] args) {
    Game game = new Game();

    Window window = new Window("Eat 'n' Run", WIDTH, HEIGHT);
    window.open();

    // Game loop
    while (window.isOpen()) {
      game.handleEvents(window);
      game.step();
      game.drawGame(window);
      window.refreshAndClear(CLEAR_SCREEN_TIME_MS);
    }
  }
}
