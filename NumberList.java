import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class NumberList {
    public static void main(Integer[] args) throws FileNotFoundException {
    }
    public static void reading() throws FileNotFoundException{
        Scanner f = new Scanner(new File("C:\\Users\\jonat\\OneDrive\\Desktop\\School\\Hangman.txt"));
        Scanner numofLines = new Scanner(new File("C:\\Users\\jonat\\OneDrive\\Desktop\\School\\Hangman.txt"));
        int lines = 0;
        while (numofLines.hasNextLine()) //Reads how many lines in the file
        {
            lines++;
            numofLines.nextLine();
        }
        ArrayList<Integer> text = new ArrayList<Integer>(lines);
        //Stores it into the Array List
        for (int i = 0; i < lines; i++) {
            text.add(f.nextInt());
        }
    }
    public static void display(ArrayList<Integer> text) {
        for (int i = 0; i < text.size(); i++) {
            System.out.println(text.get(i));
        }
    }
    public static void average(ArrayList<Integer> text){
        int average =0;
        for (int i = 0; i < text.size(); i++) {
            average = average + text.get(i);
        }
        average = average/text.size();
        System.out.println("The average is " + average);
    }
    public static void highlow(ArrayList<Integer> text){
        int high =0;
        int low = 0;
        for (int i = 0; i < text.size(); i++) {
            if(high < text.get(i)) {
                high = text.get(i);
            }
            else if (low > text.get(i)){
                low = text.get(i);
            }
        }
        System.out.println("The high is " + high + " and the low is " + low);
    }
    public static void even(ArrayList<Integer> text){
        for (int i = 0; i < text.size(); i++) {
            if(text.get(i) % 2 == 0){
                System.out.println(text.get(i));
            }
        }
    }
}

