import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import javax.swing.*;


public class TemperatureGraphClient extends Application{
    private TemperatureGraph s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;

    @Override
    public void start(Stage stage)
    {
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics(
                stage, "Graphs", 720,800);
        s1 = new TemperatureGraph( 20,stage);
//        s2 = new TemperatureGraph( 80);
//        s3 = new TemperatureGraph(140);
//        s4 = new TemperatureGraph(200);
//        s5 = new TemperatureGraph(260);
//        s6 = new TemperatureGraph(320);
//        s7 = new TemperatureGraph(380);
//        s8 = new TemperatureGraph(440);
//        s9 = new TemperatureGraph(500);
//        s10 = new TemperatureGraph(560);
//        s11 = new TemperatureGraph(620);
//        s12 = new TemperatureGraph(680);
        s1.draw(gc);
//        s2.draw(gc);
//        s3.draw(gc);
//        s4.draw(gc);
//        s5.draw(gc);
//        s6.draw(gc);
//        s7.draw(gc);
//        s8.draw(gc);
//        s9.draw(gc);
//        s10.draw(gc);
//        s11.draw(gc);
//        s12.draw(gc);

    }
    public static void main(String []args)
    {
        launch(args);
    }
}