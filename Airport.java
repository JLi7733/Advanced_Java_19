/* Airport Class
Jonathan Li
3/6/2019
Sets up the Airport info such as gate and airport number
 */
public class Airport {
    private String airportcode;
    private int gates;

    public static int countAirports = 0;

    //Default Constructor
    public Airport()
    {
        airportcode = " ";
        countAirports ++;
    }

    //Override Constructor
    public Airport(String startAirportCode, int startGates)
    {
        airportcode = startAirportCode;
        gates = startGates;
        countAirports ++;
    }

    //Accessors
    public String getAirportcode()
    {
        return airportcode;
    }
    public int getGates()
    {
        return gates;
    }
    public static int getCountAirports()
    {
        return countAirports;
    }

    //Mutators
    public void setAirportCode(String newCode)
    {
        airportcode =newCode;
    }
    public void setGates(int newGates)
    {
        if (newGates >= 0)
            gates = newGates;
        else
        {
            System.err.println("Gates must be at least 0");
            System.err.println("Value of gates unchanged");
        }
    }
    public String toString()
    {
        String airportInfo = ("The airport code is " + airportcode + " and there are " + gates + " gates.");
        return airportInfo;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean equals2(Object o) {
        if( o instanceof Airport)
        {
            Airport airport2 = (Airport) o;
            return (toString().equals(o.toString()));
        }
        else
        {
            System.err.println("That ain't a airport");
            return false;
        }
    }

}
