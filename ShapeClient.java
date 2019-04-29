import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ShapeClient extends JFrame {
    public Shape[] array = new Shape[]{new Rectangle(60,50), new Circle(50), new Triangle(30,40,50)};

    public void paint(Graphics g) {
        super.paint(g);
        try {
            draw(g, array);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
    public static void main(String[] args) throws IOException {
        ShapeClient fancy = new ShapeClient();
        fancy.setVisible(true);
        fancy.setSize(600,600);
        fancy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    //Draw Method
    public void draw(Graphics g, Shape[] arr){
        int xcoord = 100;
        int ycoord = 100;
        for(int i = 0; i<arr.length;i++){
            //Checks what shape it is
            if(arr[i] instanceof Rectangle){
                Rectangle shape = (Rectangle)arr[i];
                g.fillRect(xcoord,ycoord,shape.getWidth(), shape.getHeight());
                xcoord =xcoord+shape.getWidth() +20;
            }
            else if(arr[i] instanceof Circle){
                Circle shape2 = (Circle)arr[i];
                g.fillOval(xcoord,ycoord,shape2.getRadius(), shape2.getRadius());
                xcoord =xcoord+shape2.getRadius() +20;
            }
            //Method for drawing a triangle
            else if(arr[i] instanceof Triangle){
                Triangle shape3 = (Triangle)arr[i];
                //Find the angle of the triangle using the formula that the area of a trangle is 1/2 a*b*sin(c)
                double angle = Math.asin((2*shape3.getArea())/(shape3.getB()*shape3.getB()));
                //Find the x coord of the final point using cosine
                double oof = Math.cos(angle)*shape3.getA();
                //Convert the doubles into integers so that drawPolygon can draw them
                int superoof = (int)Math.rint(oof);
                int megaoof = (int)Math.rint(shape3.getArea()/shape3.getB()*2);
                int[] x = new int[]{xcoord, (shape3.getB()+xcoord), (superoof+xcoord)};
                int[] y = new int []{ycoord,ycoord, (ycoord + megaoof)};
                g.fillPolygon(x,y,3);
            }
            else{
                System.err.println("That isn't a shape I can print yet, sorry");
            }
        }
    }

}
