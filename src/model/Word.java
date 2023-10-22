package model;

import javax.swing.*;
import java.util.ArrayList;

public class Word {
    static String wordToGuess;
    private ArrayList<String> wordsArray = new ArrayList<>();
    public void getWordsFromUser(){
        while (true) {
            String word = JOptionPane.showInputDialog("Enter a word to place in the puzzle or type 'end' to finish.");
            if (word.equalsIgnoreCase("end")) {
                break;
            }
            if (word.length() <= 10) {
                wordsArray.add(word);
            } else {
                JOptionPane.showMessageDialog(null, "The word cannot be longer than 10 characters");
            }
        }
    }
    public void guessUserWord(ArrayList<String> words) {
        int wordsCounter = 0;
        boolean exitArray = false;

        while (!exitArray) {
            boolean wordFinded = false; // Reset to false at the beginning of each iteration.
            wordToGuess = JOptionPane.showInputDialog("Enter a word you want to search for in the puzzle.\n");

            for (String w : words) {
                if (wordToGuess != null && wordToGuess.equals(w)) {
                    wordFinded = true; //check if the word's finded.
                    wordsCounter++;
                    if (wordsCounter == words.size()) {
                        exitArray = true;
                        break;
                    }
                }
            }

            //Verify if the word has been founded.
            if (!wordFinded && wordToGuess != null) {
                JOptionPane.showMessageDialog(null, "The word " + wordToGuess + " it is not\n" +
                        "in the puzzle. Try again.");
            } else if (wordToGuess != null && wordFinded) {
                JOptionPane.showMessageDialog(null, "Well done! You have found the word: " + wordToGuess);
            }
            if (wordsCounter == words.size()) {
                JOptionPane.showMessageDialog(null, "All the words have been found, thank you for playing");
                exitArray = true;
            }
        }
    }
    public ArrayList<String> getWordsFromArrayList() {
        return wordsArray;
    }
}
