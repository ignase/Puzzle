package model;

import java.util.ArrayList;
import java.util.Random;

public class Puzzle {
    public static char[][] generatePuzzle(ArrayList<String> words) {
        int rows = 10;
        int columns = 10;
        char[][] puzzleTable = new char[rows][columns];
        Random random = new Random();
        System.out.println("The puzzle contains "+words.size()+" words.");

        // Fill the puzzleTable matrix with random letters.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                puzzleTable[i][j] = (char) (random.nextInt(26) + 'A');
            }
        }
        //Place the words in the puzzle
        for (String word : words) {
            boolean allocated = false;
            while (!allocated) {
                int randomRow = random.nextInt(rows);
                int randomColumn = random.nextInt(columns);
                int position = random.nextInt(2); // 0: horizontal, 1: vertical

                if (position == 0) { // Horizontal
                    if (randomColumn + word.length() <= columns) {
                        allocated = true;
                        for (int i = 0; i < word.length(); i++) {
                            puzzleTable[randomRow][randomColumn + i] = word.toUpperCase().charAt(i);
                        }
                    }
                } else { // Vertical
                    if (randomRow + word.length() <= rows) {
                        allocated = true;
                        for (int i = 0; i < word.length(); i++) {
                            puzzleTable[randomRow + i][randomColumn] = word.toUpperCase().charAt(i);
                        }
                    }
                }
            }
        }
        return puzzleTable;
    }
    public void printPuzzle(char[][] puzzle) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                System.out.print(" ");
                System.out.print(puzzle[i][j]);
            }
            System.out.println();
        }
    }
}