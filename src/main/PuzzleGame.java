package main;

import model.Puzzle;
import model.Word;

public class PuzzleGame {
    public static void main(String[] args) {
        Word word = new Word();
        word.getWordsFromUser();

        Puzzle puzzle = new Puzzle();
        char[][] puzzleTable = Puzzle.generatePuzzle(word.getWordsFromArrayList());
        System.out.println();

        puzzle.printPuzzle(puzzleTable);

        word.guessUserWord(word.getWordsFromArrayList());

    }
}