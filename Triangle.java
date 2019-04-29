public class Triangle implements Shape{
    private int a;
    private int b;
    private int c;
    public Triangle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void perimeter(){
        int perimeter = 0;
        perimeter = a+b+c;
        System.out.println("The perimeter of the triangle is " + perimeter);
    }
    public void area(){
        double area;
        int s = (a+b+c)/2;
        area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.out.println("The area of the triangle is " + area);
    }
    public double getArea(){
        int s = (a+b+c)/2;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return area;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}

