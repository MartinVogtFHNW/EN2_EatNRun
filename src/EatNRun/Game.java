package EatNRun;

import gui.Window;

public class Game {

  private int width;
  private int height;
  private final int PLAYER_HEIGHT = 30;
  private final int PLAYER_WIDTH = 20;
  private final int GAME_OBJECT_SIZE = 40;

  // TODO: init all gameobjects
  Player player = new Player(400, 300, PLAYER_WIDTH, PLAYER_HEIGHT);
  Finish finish = new Finish(600, 300, GAME_OBJECT_SIZE, GAME_OBJECT_SIZE);
  Wall wall = new Wall(200, 300, GAME_OBJECT_SIZE, GAME_OBJECT_SIZE);
  Cake cake = new Cake(400, 150, GAME_OBJECT_SIZE, GAME_OBJECT_SIZE);
  Monster monster = new Monster(400, 450, GAME_OBJECT_SIZE, GAME_OBJECT_SIZE);
  

  public Game(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Handles game events like intersections and
   * buttons pressed by the player
   */
  public void handleEvents(Window window) {
    // player
    if (window.isKeyPressed("up")) {
      player.moveUp();
    }
    if (window.isKeyPressed("down")) {
      player.moveDown();
    }
    if (window.isKeyPressed("left")) {
      player.moveLeft();
    }
    if (window.isKeyPressed("right")) {
      player.moveRight();
    }
    // finish
    if (player.intersects(finish)) {
      System.out.println("player intersects finish!");
    }
    // walls
    if (player.intersects(wall)) {
      System.out.println("player intersects wall!");
    }
    // cake
    if (player.intersects(cake)) {
      System.out.println("player intersects cake!");
    }
    // monster
    if (player.intersects(monster)) {
      System.out.println("player intersects monster!");
    }
  }

  /**
   * Processes a single game step
   */
  public void step() {

  }

  /**
   * Draws the current state of the game to the window
   */
  public void drawGame(Window window) {
    // player
    player.draw(window);

    // finish
    finish.draw(window);

    // wall
    wall.draw(window);

    // cake
    cake.draw(window);

    // monster
    monster.draw(window);
  }
}
