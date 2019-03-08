public class AutoClient {
    public static void main(String[] args)
    {
        Automobile car1 = new Automobile("Ford", 9, 7.8);
        Automobile car2 = new Automobile("Car", 6);
        System.out.println(car1.toString());
        if(car1.equals(car2))
        {
            System.out.println("These two cars are the same");
        }
        else
            System.out.println("These two cars are different");
    }
}
