package Assignment8;

import java.io.IOException;
import java.util.*;

public class FileCounter {
    private int characterCount, wordCount, lineCount;

    public FileCounter() {
        characterCount = 0;
        wordCount = 0;
        lineCount = 0;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }



    /**
     Processes an input source and adds its character, word, and line
     counts to the respective variables.
     @param in the scanner to process
     */
    public void read(Scanner in) throws IOException {
        // your code
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()){
            String line = in.nextLine();
            sb.append(line);
            lineCount++;
            wordCount += line.split(" ").length;
            characterCount += line.length();
        }
    }
}
