public class Circle implements Shape{
    private int radius;
    public Circle(int r){
        radius = r;
    }
    public void perimeter(){
        double perimeter = radius*2* Math.PI;
        System.out.println("The perimeter of the circle is " + perimeter);
    }
    public void area(){
        double area = radius*radius*Math.PI;
        System.out.println("The area of the circle is " + area);
    }

    public int getRadius() {
        return radius;
    }
}
