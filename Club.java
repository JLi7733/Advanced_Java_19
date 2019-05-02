public class Club extends Venue {
    private String genre;
    private final double seat$;
    private int ticketsSold;

    public Club(String name, int capacity, String musicType, double ticketPrice){
        super(name, capacity);
        seat$ = ticketPrice;
        genre = musicType;
    }

    @Override
    public double getRevenue() {
        return seat$*ticketsSold;
    }
}
