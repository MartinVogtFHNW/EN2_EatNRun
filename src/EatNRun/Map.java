package EatNRun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import gui.Window;

public class Map {

    private final static int LEVEL_WIDTH = 20;
    private final static int LEVEL_HIGHT = 15;
    public static void main(String[] args) {
        String[][] level = loadMatrixFromTextFile(1);

        for (int i = 0; i < level.length; i++) {
            System.out.println(Arrays.toString(level[i]));
        }
    }

    /**
     * reads level from file
     * @param level number of leve to load
     * @return a two dimensional array of strings
     */
    private static String[][] loadMatrixFromTextFile(int level) {
        try {
            String[] input = Files.readAllLines(Paths.get("resources", "maps", level + ".txt")).toArray(new String[]{});
            String[][] matrix = new String[LEVEL_HIGHT][LEVEL_WIDTH];

            for (int i = 0; i < LEVEL_HIGHT; i++) {
                for (int j = 0; j < LEVEL_WIDTH; j++) {
                    char[] temp = input[i].toCharArray();
                    matrix[i][j] = "" + temp[j];
                }
            }
            return matrix;
        } catch(IOException iox) {
            throw new RuntimeException(iox);
        }
    }

    public static void draw() {
        
    }

    
}


/*
 * Level mit 15 Zeilen mit jeweils 20 Zeichen
 *
 * #: Hindernis
 * P: Player (der blaue Spieler unten links)
 * F: Finish (das Ziel oben rechts)
 * C: Cake (die Kuchen)
 * 
 * Die grünen Monster. Die Kürzel stehen für die Himmelsrichtung in der sie initial loslaufen.
 * N: Norden/Oben
 * E: Osten/Rechts
 * S: Süden/Unten
 * W: Westen/Links 
 */

// 
// [#, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #]
// [#,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , F, #]
// [#,  ,  , #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #]
// [#,  ,  , E,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , C, #]
// [#, #, #, #, #, #, #, #, #, #, #,  ,  ,  ,  , #, #, #, #, #]
// [#,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , N,  ,  ,  , C, #]
// [#, #,  ,  , #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #]
// [#, C,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , #]
// [#, #, #, #, #, #,  , #, #, #, #,  ,  , #, #, #, #, #, #, #]
// [#,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , #]
// [#, C, C,  , #, N, S, #, #, #, #, #, #, #, #,  ,  ,  ,  , #]
// [#,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , #]
// [#, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #,  ,  ,  , #]
// [#, P,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  ,  , C, #]
// [#, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #, #]