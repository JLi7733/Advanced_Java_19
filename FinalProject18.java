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
        do {
            Gallows(g);
            ArrayList<String> InputLetter = new ArrayList<String>();
//        //Reads a random word from the file
            Scanner f = new Scanner(new File("C:\\Users\\jonat\\IdeaProjects\\School\\src\\Hangman.txt.txt"));
            Scanner numofLines = new Scanner(new File("C:\\Users\\jonat\\IdeaProjects\\School\\src\\Hangman.txt.txt"));
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
            int mistakes = 0; //Initialized # of mistakes
            do {
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
                } else {
                    int occurenceOfValidLetter = 0;
                    while(isLetterValid>=0)//checks how many times it is in the word and draws it in the corresponding blanks
                    {
                        occurenceOfValidLetter++;
                        g.drawString(guess, 100 + 50 * isLetterValid, 525);
                        isLetterValid = word.indexOf(guess, isLetterValid+1);
                    }
                    wordLength = wordLength - occurenceOfValidLetter;
                }
                //Draws the next body part if you didn't guess correctly
                switch (mistakes) {
                    case 0:
                        if (wordLength == 0) {
                            keepGuessing = false;
                            keepPlaying = GameWon("Good Job, you won!");
                        }
                        break;
                    case 1:
                        g.drawOval(350, 150, 100, 100);
                        if (wordLength == 0) {
                            keepGuessing = false;
                            keepPlaying = GameWon("Good Job, you won!");
                        }
                        break;
                    case 2:
                        g.drawLine(400, 250, 400, 350);
                        if (wordLength == 0) {
                            keepGuessing = false;
                            keepPlaying = GameWon("Good Job, you won!");
                        }
                        break;
                    case 3:
                        g.drawLine(400, 300, 350, 350);
                        if (wordLength == 0) {
                            keepGuessing = false;
                            keepPlaying = GameWon("Good Job, you won!");
                        }
                        break;
                    case 4:
                        g.drawLine(400, 300, 450, 350);
                        if (wordLength == 0) {
                            keepGuessing = false;
                            keepPlaying = GameWon("Good Job, you won!");
                        }
                        break;
                    case 5:
                        g.drawLine(400, 350, 350, 400);
                        if (wordLength == 0) {
                            keepGuessing = false;
                            keepPlaying = GameWon("Good Job, you won!");
                        }
                        break;
                    case 6:
                        g.drawLine(400,350,450,400);
                        keepGuessing = false;
                        keepPlaying = GameWon("Sorry you lost");
                }
            } while (keepGuessing);
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

    public static void main(String [] args) throws IOException
    {
        FinalProject18 fancy = new FinalProject18();
        fancy.setVisible(true);
        fancy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fancy.setSize(600,600);
    }
}
