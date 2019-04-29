public class Rectangle implements Shape{
    private int width;
    private int height;
    public Rectangle(int w, int h){
        width = w;
        height = h;
    }
    public void perimeter(){
        int perimeter = 0;
        perimeter = (width+height)*2;
        System.out.println("The perimeter of the rectangle is " + perimeter);
    }
    public void area(){
        int area;
        area = width*height;
        System.out.println("The area of the rectangle is " + area);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
