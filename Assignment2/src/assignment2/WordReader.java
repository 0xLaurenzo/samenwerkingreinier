package assignment2;

import java.util.Scanner;
import java.util.Random;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads words from a given file and
 * selects one of those words pseudo randomly
 * OO 2018 exercise 2
 *
 * @author Pieter Koopman
 */
public class WordReader {
    private final List<String> words;
    private final Random rand;

    /**
     * Saves words from the file in an arrayList
     * IOexceptions while reading the file are caught and printed
     *
     * @param fileName: fileName of the file with the words
     */
    public WordReader(String fileName) {
        rand = new Random ();
        words = new ArrayList<> ();
        String pattern = "\\S+"; // consisting of at least one non-space

        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner file = new Scanner(fileReader);

            while (file.hasNext(pattern)) {
                words.add(file.next(pattern).toLowerCase());
            }
            fileReader.close();
        } catch ( IOException ioe ) {
            System.out.println("Error while reading file with name " + fileName +
                    ": " + ioe.getMessage() );
        }
    }

    /**
     * @return the number of read words.
     */
    public int getNumberOfWords() {
        return words.size();
    }

    /**
     * Gives a pseudo random word from the list of words
     * or returns the empty word if the list is empty
     *
     * @return a pseudo random word
     */
    public String getWord() {
        if (! words.isEmpty()) {
            return words.get(rand.nextInt(getNumberOfWords()));
        } else {
            return "";
        }
    }
}
