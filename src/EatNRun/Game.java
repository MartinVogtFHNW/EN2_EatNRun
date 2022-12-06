package EatNRun;

import gui.Window;
import java.util.ArrayList;

public class Game {

  private int width;
  private int height;
  private int level = 1;
  private int levels;
  private int playerLifes = 5;
  private int playerCakes;
  private boolean won = false;
  private boolean lost = false;

  private final int PLAYER_HEIGHT = 30;
  private final int PLAYER_WIDTH = 20;
  private final int GAME_OBJECT_SIZE = 40;
  private final int SCREEN_OFFSET = 20;

  Player player;
  Finish finish;
  ArrayList<Wall> walls;
  ArrayList<Cake> cakes;
  ArrayList<Monster> monsters;

  public Game(int width, int height) {
    this.width = width;
    this.height = height;
    levels = Level.getNumberOfLevels();
    loadLevel(level);
  }

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
              field * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              row * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              GAME_OBJECT_SIZE,
              GAME_OBJECT_SIZE
            )
          );
          case 'P' -> player =
            new Player(
              field * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              row * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              PLAYER_WIDTH,
              PLAYER_HEIGHT
            );
          case 'F' -> finish =
            new Finish(
              field * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              row * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              GAME_OBJECT_SIZE,
              GAME_OBJECT_SIZE
            );
          case 'C' -> cakes.add(
            new Cake(
              field * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              row * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              GAME_OBJECT_SIZE,
              GAME_OBJECT_SIZE
            )
          );
          case 'N', 'E', 'S', 'W' -> monsters.add(
            new Monster(
              field * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              row * GAME_OBJECT_SIZE + SCREEN_OFFSET,
              GAME_OBJECT_SIZE,
              GAME_OBJECT_SIZE
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

    // player intersects cake
    for (int cake = 0; cake < cakes.size(); cake++) {
      if (cakes.get(cake).intersects(player)) {
        playerCakes++;
        cakes.remove(cake);
      }
    }

    // player intersects finish
    if (player.intersects(finish)) {
      if (level < levels) {
        level++;
        loadLevel(level);
      } else {
        won = true;
      }
    }

    // player intersects monster
    for (int monster = 0; monster < monsters.size(); monster++) {
      if (monsters.get(monster).intersects(player)) {
        if (playerLifes > 1) {
          playerLifes--;
          player.resetToStart();
        } else {
          lost = true;
        }
      }
    }
  }

  /**
   * Processes a single game step
   */
  public void step() {}

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
    window.setBold(true);
    window.setColor(255, 255, 255);
    window.setFontSize(25);
    window.drawStringCentered(
      "Cakes: " + playerCakes + " Lifes: " + playerLifes + " Level: " + level,
      width / 2,
      30
    );

    // show LOSE screen
    if (lost) {
      window.setColor(255, 255, 255);
      window.fillRect(0, 0, width, height);

      window.setColor(0, 0, 0);
      window.setFontSize(50);
      window.drawStringCentered("You LOSE!", width / 2, height / 2);
    }

    // show WIN screen
    if (won) {
      window.setColor(255, 255, 255);
      window.fillRect(0, 0, width, height);

      window.setColor(0, 0, 0);
      window.setFontSize(50);
      window.drawStringCentered("You WIN!", width / 2, height / 2);
    }
  }
}
