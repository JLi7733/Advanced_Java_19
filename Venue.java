public abstract class Venue {
    private String name;
    private int capacity;

    public Venue(String myName, int myCapacity){
        name = myName;
        capacity =myCapacity;
    }
    public abstract double getRevenue();
}
