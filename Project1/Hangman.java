package Project1;

import java.util.*;
import java.io.*;

class Hangman {

    ArrayList<String> words = new ArrayList<>();
    ArrayList<Character> correctList;
    ArrayList<Character> wrongList;
    boolean[] foundLetters;
    String choseWord;


    public Hangman(ArrayList<String> words) {

        this.words = words;
        wrongList = new ArrayList<>();
        correctList = new ArrayList<>();
    }

    private void chooseWord() {
        choseWord =  words.get((int) (Math.random() * words.size()));
        foundLetters = new boolean[choseWord.length()];
        for (int i = 0; i < choseWord.length(); i++) {
            correctList.add('_');
        }
    }

    private void handleGuess(char guess) {
        boolean find = false;
        for (int i = 0; i < choseWord.length(); i++) {
            if (choseWord.charAt(i) == guess) {
                correctList.set(i, guess);
                foundLetters[i] = true;
                find = true;
            }
        }

        if (find == false) {
            wrongList.add(guess);
        }

    }

    private boolean gameWon() {
        for(int i = 0; i < foundLetters.length; i++) {
            if(foundLetters[i] == false) {
                return false;
            }
        }
        return true;
    }

    private void gameOver() {
        if (wrongList.size() >= 8) {
            System.out.println("Sorry, but you lose");
        } else {
            System.out.println("Congratulations! You win the game!");
        }

        wrongList = null;
        correctList = null;
        choseWord = null;
        System.exit(0);
    }

    private void printHangman() {
        System.out.println("------------------");
        System.out.println("|               |");
        switch (wrongList.size()) {
            case 1:
                System.out.println("|               O");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
            case 2:
                System.out.println("|               O");
                System.out.println("|               |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
            case 3:
                System.out.println("|               O");
                System.out.println("|               |");
                System.out.println("|            --- ");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
            case 4:
                System.out.println("|               O");
                System.out.println("|               |");
                System.out.println("|            --- ---");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
            case 5:
                System.out.println("|               O");
                System.out.println("|               |");
                System.out.println("|            --- ---");
                System.out.println("|              /");
                System.out.println("|             /");
                System.out.println("|");
                break;
            case 6:
                System.out.println("|               O");
                System.out.println("|               |");
                System.out.println("|            --- ---");
                System.out.println("|              / \\");
                System.out.println("|             /   \\");
                System.out.println("|");
                break;
            case 7:
                System.out.println("|               O");
                System.out.println("|               |");
                System.out.println("|            --- ---");
                System.out.println("|              / \\");
                System.out.println("|             /   \\");
                System.out.println("|          ---");
                break;
            case 8:
                System.out.println("|               O");
                System.out.println("|               |");
                System.out.println("|            --- ---");
                System.out.println("|              / \\");
                System.out.println("|             /   \\");
                System.out.println("|          ---      ---");
                break;
            default:
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
        }

        System.out.println("|");
        System.out.println("---------------------------");
    }

    private void displayWord() {
        StringBuilder sb= new StringBuilder();

        for (char i : choseWord.toCharArray()){
            if (correctList.contains(i)) {
                sb.append(i);
            }
            else sb.append('_');
        }
        System.out.println("Word to guess is " + sb.toString());
        System.out.println("You have " + (8 - wrongList.size()) + " chance to guess");
    }

    private void playGame() {
        System.out.println("Welcome to Hangman!");
        chooseWord();
        while (!gameWon() && wrongList.size() < 8) {
            System.out.flush();
            displayWord();
            printHangman();
            System.out.println("One letter please");
            Scanner input = new Scanner(System.in);
            Character guess = input.next().charAt(0);
            handleGuess(guess);
        }
        displayWord();
        printHangman();
        gameOver();

    }


    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("yes");
        words.add("gotoweb");
        Hangman hangman = new Hangman(words);
        hangman.playGame();
    }
}