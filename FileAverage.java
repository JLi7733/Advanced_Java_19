import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileAverage {
    public static void main(String[] args) {
        try {
            Scanner file = new Scanner(new File("C:\\Users\\jonat\\OneDrive\\Desktop\\School\\Cofeve.txt"));
            ArrayList Prices  = new ArrayList <Double>(5);
            String s = "";
            String name = "";
            int count = 0;
            double temp = 0;
            double price = 0;
            while(file.hasNextLine()){
                s = file.next();
                try{
                    temp = temp + Double.parseDouble(s);
                    count++;
                }
                catch (NumberFormatException e){
                    if(temp != 0) {
                        price = temp / count;
                        count = 0;
                        System.out.println("The average price of " + name + " is " + price);
                        temp = 0;
                    }
                    else{
                        name = s;
                    }
                }
            }

        }catch(IOException e){
            System.out.println("oof");
        }
    }
}
