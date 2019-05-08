import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HomeworkTest {
    public static void main(String[] args) {
        String s = "";
        int n = 0;
        try{
            Scanner file = new Scanner(new File("C:\\Users\\jonat\\OneDrive\\Desktop\\School\\data.txt"));
            while(file.hasNext())
            {
                s=file.nextLine();
                try{
                    n=Integer.parseInt(s);
                    System.out.println(n);
                }
                catch(NumberFormatException e){
                }

            }
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        dataRead();
    }
    public static void findC(){
        Scanner parse = new Scanner("A-B-C-D");
        parse.useDelimiter("-");
        String s = "";
        while(parse.hasNext()) {
            s = parse.next();
            if(s.equals("C"))
            System.out.println(s);
        }
    }
    public static void dataRead(){
        try{
            Scanner file = new Scanner(new File("C:\\Users\\jonat\\OneDrive\\Desktop\\School\\data.txt"));
            for(int i=0;i<2;i++){
                System.out.println(file.nextLine());
            }
            String s = "";
            String temp=" ";
            while(file.hasNextLine()){
                s=file.nextLine();
                if(s.compareTo(temp) > 0){
                    temp = s;
                }
                System.out.println(temp);
                //If has spaces
                if(!s.contains(" ")){
                    System.out.println(s);
                }
                //has SP
                if(s.contains("Sp")){
                    System.out.println(s);
                }
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}