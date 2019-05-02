public class Stadium extends Venue {
    private final int premium$ = 200;
    private final int general$ = 75;
    private final int maxPremium;
    private final int maxGeneral;
    private int premiumSold, generalSold;

    public Stadium(String name, int capacity, int premiumSeats){
        super(name, capacity);
        maxPremium = premiumSeats;
        maxGeneral = capacity - premiumSeats;
    }

    @Override
    public double getRevenue() {
        return premium$*premiumSold + general$*generalSold;
    }
}
