package EatNRun;

import EatNRun.util.Sound;
import EatNRun.view.Score;
import EatNRun.view.Screen;
import gui.Window;
import java.util.ArrayList;

public class Game {

  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;
  private int level = 1;
  private int levels;
  private int playerLives = 5;
  private int playerCakes;
  private boolean won = false;
  private boolean lost = false;

  private final int GAME_RASTER_SIZE = 40;
  private final int SCREEN_OFFSET = 20;

  public Game() {
    levels = Level.getNumberOfLevels();
    loadLevel(level);
  }

  Player player;
  Finish finish;
  ArrayList<Wall> walls;
  ArrayList<Cake> cakes;
  ArrayList<Monster> monsters;
  Screen loseScreen = new Screen(WIDTH, HEIGHT, "Game Over!");
  Screen winScreen = new Screen(WIDTH, HEIGHT, "You WIN!");

  /**
   * load level and create game objects
   * @param level
   */
  public void loadLevel(int level) {
    String[] map = Level.loadMatrixFromTextFile(level);

    walls = new ArrayList<Wall>();
    cakes = new ArrayList<Cake>();
    monsters = new ArrayList<Monster>();

    for (int row = 0; row < map.length; row++) {
      for (int field = 0; field < map[row].length(); field++) {
        switch (map[row].charAt(field)) {
          case '#' -> walls.add(
            new Wall(
              field * GAME_RASTER_SIZE + SCREEN_OFFSET,
              row * GAME_RASTER_SIZE + SCREEN_OFFSET
            )
          );
          case 'P' -> player =
            new Player(
              field * GAME_RASTER_SIZE + SCREEN_OFFSET,
              row * GAME_RASTER_SIZE + SCREEN_OFFSET
            );
          case 'F' -> finish =
            new Finish(
              field * GAME_RASTER_SIZE + SCREEN_OFFSET,
              row * GAME_RASTER_SIZE + SCREEN_OFFSET
            );
          case 'C' -> cakes.add(
            new Cake(
              field * GAME_RASTER_SIZE + SCREEN_OFFSET,
              row * GAME_RASTER_SIZE + SCREEN_OFFSET
            )
          );
          case 'N' -> monsters.add(
            new Monster(
              field * GAME_RASTER_SIZE + SCREEN_OFFSET,
              row * GAME_RASTER_SIZE + SCREEN_OFFSET,
              0,
              -4
            )
          );
          case 'E' -> monsters.add(
            new Monster(
              field * GAME_RASTER_SIZE + SCREEN_OFFSET,
              row * GAME_RASTER_SIZE + SCREEN_OFFSET,
              4,
              0
            )
          );
          case 'S' -> monsters.add(
            new Monster(
              field * GAME_RASTER_SIZE + SCREEN_OFFSET,
              row * GAME_RASTER_SIZE + SCREEN_OFFSET,
              0,
              4
            )
          );
          case 'W' -> monsters.add(
            new Monster(
              field * GAME_RASTER_SIZE + SCREEN_OFFSET,
              row * GAME_RASTER_SIZE + SCREEN_OFFSET,
              -4,
              0
            )
          );
        }
      }
    }
  }

  /**
   * Handles game events like intersections and
   * buttons pressed by the player
   */
  public void handleEvents(Window window) {
    // player move
    if (window.isKeyPressed("up")) {
      player.moveUp();
      for (int wall = 0; wall < walls.size(); wall++) {
        if (player.intersects(walls.get(wall))) {
          player.moveDown();
        }
      }
    }
    if (window.isKeyPressed("down")) {
      player.moveDown();
      for (int wall = 0; wall < walls.size(); wall++) {
        if (player.intersects(walls.get(wall))) {
          player.moveUp();
        }
      }
    }
    if (window.isKeyPressed("left")) {
      player.moveLeft();
      for (int wall = 0; wall < walls.size(); wall++) {
        if (player.intersects(walls.get(wall))) {
          player.moveRight();
        }
      }
    }
    if (window.isKeyPressed("right")) {
      player.moveRight();
      for (int wall = 0; wall < walls.size(); wall++) {
        if (player.intersects(walls.get(wall))) {
          player.moveLeft();
        }
      }
    }

    // player intersects cake
    for (int cake = 0; cake < cakes.size(); cake++) {
      if (cakes.get(cake).intersects(player)) {
        playerCakes++;
        cakes.remove(cake);
        Sound.playSound(Sound.SLURP);
      }
    }

    // player intersects finish
    if (player.intersects(finish)) {
      if (level < levels) {
        level++;
        loadLevel(level);
      } else {
        won = true;
        Sound.playSound(Sound.SUCCESS);
      }
    }

    // player intersects monster
    for (int monster = 0; monster < monsters.size(); monster++) {
      if (monsters.get(monster).intersects(player)) {
        if (playerLives > 1) {
          playerLives--;
          player.resetToStart();
          Sound.playSound(Sound.DIE);
        } else {
          lost = true;
          Sound.playSound(Sound.GAME_OVER);
        }
      }
    }

    // monster intersects wall
    for (int monster = 0; monster < monsters.size(); monster++) {
      for (int wall = 0; wall < walls.size(); wall++) {
        if (monsters.get(monster).intersects(walls.get(wall))) {
          monsters.get(monster).bounceOfWall();
        }
      }
    }
  }

  /**
   * Processes a single game step
   */
  public void step() {
    // move monsters
    for (int monster = 0; monster < monsters.size(); monster++) {
      monsters.get(monster).move();
    }
  }

  /**
   * Draws the current state of the game to the window
   */
  public void drawGame(Window window) {
    
    // draw player
    player.draw(window);

    // draw finish
    finish.draw(window);

    // draw walls
    for (Wall wall : walls) {
      wall.draw(window);
    }

    // draw cakes
    for (Cake cake : cakes) {
      cake.draw(window);
    }

    // draw monsters
    for (Monster monster : monsters) {
      monster.draw(window);
    }

    // draw score
    Score.draw(window, WIDTH, playerCakes, playerLives, level);

    // show LOSE screen
    if (lost) {
      loseScreen.draw(window);
    }

    // show WIN screen
    if (won) {
      winScreen.draw(window);
    }
  }
}
