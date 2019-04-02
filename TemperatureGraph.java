import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;

public class TemperatureGraph {
    private double sX;
    private String month;
    private int temp;
    public TemperatureGraph input[] = new TemperatureGraph[12];
    public TemperatureGraph(double x, String Month, int Temp)
    {
        setCoordinates(x);
        month = Month;
        temp = Temp;
    }
    public TemperatureGraph(String Month)
    {
        setCoordinates(0);
        month = Month;
        temp = 0;
    }
    public TemperatureGraph(double x, Stage stage)
    {
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics(
                stage, "Graphs", 720,800);
        for(int i=0; i<input.length; i++) {
//            String return JOptionPane.showInputDialog(null, "Enter the month");
            int Temp = 0;
            boolean check = true;
            String Month = checkMonth(i);
            do {
                try {
                    Temp = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the temp, the month is " + Month));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                }
                if(i == 11 || i <2 && Temp<=50 && Temp>=-30)
                {
                    temp =Temp;
                    check = false;
                }
                else if(i >1 && i <5 && Temp<=80 && Temp>=50)
                {
                    temp =Temp;
                    check = false;
                }
                else if(i >4 && i <8 && Temp<=110 && Temp>=80)
                {
                    temp =Temp;
                    check = false;
                }
                else if(i >7 && i <11 && Temp<80 && Temp>=40)
                {
                    temp =Temp;
                    check = false;
                }
                else
                    JOptionPane.showMessageDialog(null, "Please enter a reasonable temperature in integer form");
            } while (check);
            temp = Temp;
            TemperatureGraph obj = new TemperatureGraph(x,Month,Temp);
            setCoordinates(x);
            obj.draw(gc);
            x = x + 60;
            input[i] = obj;
        }
        int maxIndex = 0;
        int lowIndex = 0;
        int average = 0;
        for(int i = 0;i <input.length;i++)
        {
            if(input[i].temp > input[maxIndex].temp)
                maxIndex=i;
        }
        for(int i = 0;i <input.length;i++)
        {
            if(input[i].temp < input[lowIndex].temp)
                lowIndex=i;
        }
        for(int i = 0;i <input.length;i++)
        {
            average = average + input[i].temp;
        }
        average = average/input.length;
        input[maxIndex].info(gc, input[maxIndex],input[lowIndex],average);

    }
    public TemperatureGraph setCoordinates(double sX)
    {
        this.sX = sX;
        return this;
    }
    public TemperatureGraph setMonth(String month)
    {
        this.month = month;
        return this;
    }
    public TemperatureGraph setTemp(int temp)
    {
        this.temp = temp;
        return this;
    }

    public void draw(GraphicsContext gc)
    {
        if(temp<50)
            gc.setFill(Color.BLUE);
        else if (temp<80)
            gc.setFill(Color.YELLOW);
        else
            gc.setFill(Color.RED);
        gc.fillRect(sX, 500-temp*3, 20, temp*3);
        gc.setFill(Color.BLACK);
        gc.fillText(Integer.toString(temp), sX,500-temp*3-10);
        gc.fillText(month, sX, 500-temp*3-25);

    }
    public void info(GraphicsContext gc,TemperatureGraph high, TemperatureGraph low, int average)
    {
        gc.setFill(Color.BLACK);
        gc.fillText("The highest temp was in " + high.month +" at " + high.temp, 20,525);
        gc.fillText("The lowest temp was in " + low.month + " at " + low.temp, 20, 550);
        gc.fillText("The average temp was " + average, 20,575);
    }
    public String checkMonth(int Month)
    {
        String thing = "";
        switch (Month)
        {
            case 0: thing = "Jan";
                break;
            case 1: thing = "Feb";
                break;
            case 2: thing = "Mar";
                break;
            case 3: thing = "Apr";
                break;
            case 4: thing = "May";
                break;
            case 5: thing = "Jun";
                break;
            case 6: thing = "Jul";
                break;
            case 7: thing = "Aug";
                break;
            case 8: thing = "Sep";
                break;
            case 9: thing = "Oct";
                break;
            case 10: thing = "Nov";
                break;
            case 11: thing = "Dec";
                break;
        }
            return thing;
    }

}
