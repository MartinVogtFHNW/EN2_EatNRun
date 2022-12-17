package EatNRun.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Level {

  /**
   * reads level from file
   * @param level number of leve to load
   * @return a two dimensional array of strings
   */
  public static String[] loadMatrixFromTextFile(int level) {
    try {
      return Files
        .readAllLines(Paths.get("resources", "maps", level + ".txt"))
        .toArray(new String[] {});
    } catch (IOException iox) {
      throw new RuntimeException(iox);
    }
  }

  /**
   * get loadable levels from file
   * @return array of levelnames available
   */
  public static int getNumberOfLevels() {
    try {
      return (int) Files
        .list(Paths.get("resources", "maps"))
        .filter(p -> p.toFile().getName().endsWith(".txt"))
        .count();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
