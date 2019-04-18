import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class FileReading {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner f = new Scanner(new File("C:\\Users\\jonat\\OneDrive\\Desktop\\School\\Hangman.txt"));
        Scanner numofLines = new Scanner(new File("C:\\Users\\jonat\\OneDrive\\Desktop\\School\\Hangman.txt"));
        int lines = 0;
        while (numofLines.hasNextLine()) //Reads how many lines in the file
        {
            lines++;
            numofLines.nextLine();
        }
        ArrayList<String> text = new ArrayList<String>(lines);
        //Stores it into the Array List
        for (int i = 0; i < lines; i++) {
            text.add(f.nextLine());
        }
        for (int i = 0; i < lines; i++) {
            System.out.println(text.get(i));
        }
        //Prints in reverse
        for (int i = lines-1; i >= 0; i--) {
            System.out.println(text.get(i));
        }
        //Display the plurals and capitalize it
        for (int i = 0; i < lines; i++) {
            String word = text.get(i);
            if(word.lastIndexOf("s") == word.length()-1) {
                word = word.toUpperCase();
                text.set(i, word);
            }
            System.out.println(word);
        }
        System.out.println();
        //Display without plural words
        for (int i = 0; i < lines; i++) {
            String word = text.get(i);
            if((word.lastIndexOf("S") != word.length()-1) || (word.lastIndexOf("s") == word.length()-1)){
                System.out.println(word);
           }
        }
    }
}
