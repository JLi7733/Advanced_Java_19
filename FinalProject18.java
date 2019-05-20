/*Created by Jonathan Li
  Date: October 30 2017
  Hangman
  Guess the word in a limited amount of attempts
 */
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class FinalProject18 extends JFrame {
    public static final String[] Alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public void paint(Graphics g) {
        super.paint(g);
        try {
            Gameplay(g);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public static void Gallows(Graphics g)             //Draws the Basic Outline and clears the screen
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(Color.BLACK);
        g.drawLine(100, 500, 500, 500);
        g.drawLine(200, 500, 200, 100);
        g.drawLine(200, 100, 400, 100);
        g.drawLine(400, 100, 400, 150);
    }

    public static void Gameplay(Graphics g) throws FileNotFoundException {
        boolean keepPlaying = true;
        int x =150;
        int mistakes = 0; //Initialized # of mistakes
        do {
            Gallows(g);
            Figure[] shape = difficulty();
            ArrayList<String> InputLetter = new ArrayList<String>();
//        //Reads a random word from the file
            Scanner f = new Scanner(new File("C:\\Users\\jonat\\OneDrive\\Desktop\\School\\Hangman.txt"));
            Scanner numofLines = new Scanner(new File("C:\\Users\\jonat\\OneDrive\\Desktop\\School\\Hangman.txt"));
            Random rand = new Random();
            int lines = 0;
            while(numofLines.hasNextLine()) //Reads how many lines in the file
            {
                lines++;
                numofLines.nextLine();
            }
            int n = rand.nextInt(lines) + 1;
            String word = "";
            for (int i = n; i > 0; i--) {
                word = f.nextLine();
            }
            int wordLength = word.length();
            //Checks how many blanks to draw for the corresponding amount of letters
            for (int i = wordLength - 1; i >= 0; i--) {
                g.drawLine(100 + i * 50, 550, 110 + i * 50, 550);
            }
            boolean keepGuessing = true;//The guessing portion of the game
            do{
            if(guessOption()){
                String guess = JOptionPane.showInputDialog(null,"Enter the word you think it is");
                keepGuessing = false;
                if(guess.equalsIgnoreCase(word)){
                    keepPlaying = GameWon("Congrats you won");
                }
                else
                    keepPlaying = GameWon("Sorry you lost, the word was " + word);

            }
            else {
                    //Checks the user input:letter only, one letter, and if they have already entered this letter
                    boolean check = true;
                    String guess = JOptionPane.showInputDialog(null, "Enter a letter");
                    do {
                        guess = guess.toLowerCase();
                        if (guess.length() == 1 && Arrays.asList(Alphabet).contains(guess) && !InputLetter.contains(guess)) {
                            check = false;
                            InputLetter.add(guess);
                        } else if (InputLetter.contains(guess)) {
                            guess = JOptionPane.showInputDialog(null, "Sorry, you've already entered " + guess);
                        } else {
                            guess = JOptionPane.showInputDialog(null, "Please only enter one letter from the alphabet");
                        }
                    } while (check);
                    //Check if the player's input letter is in the word.
                    int isLetterValid = word.indexOf(guess);
                    if (isLetterValid == -1) {
                        mistakes = mistakes + 1;
                        g.drawString("Guessed Letters:", 50, 100);
                        g.drawString(guess, x, 100);
                        x = x + 10;
                        System.out.println(mistakes);
                        shape[mistakes -1].draw(g);
                    } else {
                        int occurenceOfValidLetter = 0;
                        while (isLetterValid >= 0)//checks how many times it is in the word and draws it in the corresponding blanks
                        {
                            occurenceOfValidLetter++;
                            g.drawString(guess, 100 + 50 * isLetterValid, 525);
                            isLetterValid = word.indexOf(guess, isLetterValid + 1);
                        }
                        wordLength = wordLength - occurenceOfValidLetter;
                    }
                    if(wordLength == 0){
                        keepGuessing = false;
                        keepPlaying = GameWon("Good Job, you won!");
                    }
                    else if(mistakes == shape.length){
                        keepGuessing = false;
                        keepPlaying = GameWon("Sorry you lost, the word was " + word);
                    }
                }
            }while (keepGuessing);
            mistakes = 0;
            x = 150;
        } while (keepPlaying);
    }
    //End of Game Routine
    public static boolean GameWon(String Message) {
        Object[] options = {"Yes", "No"};
        int p = JOptionPane.showOptionDialog(null,
                Message + "\n Do you wanna play again?",
                "Play Again",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (p == 1) {
            return false;
        }
        else
        {
            return true;
        }
    }
    //Choosing what to guess
    public static boolean guessOption() {
        Object[] options = {"Word", "Letter"};
        int p = JOptionPane.showOptionDialog(null,
                " What do you want to guess \n" +
                        "Note: If you guess the word you only get one shot.",
                "Guessing",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (p == 1) {
            return false;
        }
        else
        {
            return true;
        }
    }
    //Choosing the difficulty
    public static Figure[] difficulty(){
        Object[] options = {"Normal", "Easy"};
        int p = JOptionPane.showOptionDialog(null,
                " Choose your difficulty \n" +
                        "The harder it is the less guesses you get",
                "Difficulty",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        Figure[] pieces = new Figure[]{};
        switch (p){
            case 0: pieces = new Figure[]{new Circle(350, 150, Color.BLACK,50),
                    new Line(400, 250, Color.BLACK, 400, 350),
                    new Line(400, 300, Color.BLACK,350, 350),
                    new Line(400, 300, Color.BLACK,450, 350),
                    new Line(400, 350, Color.BLACK, 350, 400),
                    new Line(400, 350, Color.BLACK, 450, 400)
                    };
            case 1: pieces = new Figure[]{new Circle(350, 150, Color.BLACK,50),
                    new Line(400, 250, Color.BLACK, 400, 350),
                    new Line(400, 300, Color.BLACK,350, 350),
                    new Line(400, 300, Color.BLACK,450, 350),
                    new Line(400, 350, Color.BLACK, 350, 400),
                    new Line(400, 350, Color.BLACK, 450, 400),
                    new Circle(365,175,Color.BLACK, 10),
                    new Circle(410,175,Color.BLACK, 10)
            };
        }
        return pieces;
    }

    public static void main(String [] args) throws IOException
    {
        FinalProject18 fancy = new FinalProject18();
        fancy.setVisible(true);
        fancy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fancy.setSize(600,600);
    }
}
