public class Pixel {
    private int red;
    private int green;
    private int blue;

    public Pixel(int myRed, int myGreen, int myBlue){
        red = myRed;
        green = myGreen;
        blue = myBlue;
    }
    public String toString(){
        return "(" + red + ", " + green + ", " +blue + ")";
    }


}
