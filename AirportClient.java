public class AirportClient
{
    public static void main(String[] args) {
        //Airport Objects
        Airport airport1 = new Airport("DFW", 2);
        System.out.println(airport1.toString());
        Airport airport2 = new Airport("ORD", 2);
        Automobile car1 = new Automobile("Ford", 5, 6);
        if(airport1.equals2(car1))
            System.out.println("Airports are the same");
        else
            System.out.println("It's a different airport");
    }
}