package EatNRun;

import gui.Window;

public class Game {

  private int width;
  private int height;

  public Game(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Handles game events like intersections and
   * buttons pressed by the player
   */
  public void handleEvents(Window window) {}

  /**
   * Processes a single game step
   */
  public void step() {}

  /**
   * Draws the current state of the game to the window
   */
  public void drawGame(Window window) {}
}
