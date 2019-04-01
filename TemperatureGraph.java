import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;

import javax.swing.*;

public class TemperatureGraph {
    private double sX;
    private String month;
    private int temp;
    public TemperatureGraph input[] = new TemperatureGraph[2];
    public TemperatureGraph(double x, String Month, int Temp)
    {
        setCoordinates(x);
        month = Month;
        temp = Temp;
    }
    public TemperatureGraph(double x, Stage stage)
    {
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics(
                stage, "Graphs", 720,800);
        for(int i=0; i<input.length; i++) {
            String Month = JOptionPane.showInputDialog(null, "Enter the month");
            int Temp = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the temp"));
            month = Month;
            temp = Temp;
            TemperatureGraph obj = new TemperatureGraph(x,Month,Temp);
            setCoordinates(x);
            obj.draw(gc);
            x = x + 60;
            input[i] = obj;
        }
        int maxIndex = 0;
        int lowIndex = 0;
        for(int i = 1;i <input.length;i++)
        {
            if(input[i].temp > input[maxIndex].temp)
                maxIndex=i;
        }
        for(int i = 1;i <input.length;i++)
        {
            if(input[i].temp < input[lowIndex].temp)
                lowIndex=i;
        }
        input[maxIndex].info(gc, input[maxIndex],input[lowIndex]);

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
    public void info(GraphicsContext gc,TemperatureGraph high, TemperatureGraph low)
    {
        gc.setFill(Color.BLACK);
        gc.fillText("The highest temp was in " + high.month +" at " + high.temp, 20,525);
        gc.fillText("The lowest temp was in " + low.month + " at " + low.temp, 20, 550);
    }

}
