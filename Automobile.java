public class Automobile {
    private String model;
    private int milesDriven;
    private double gallonsOfGas;
    //constructors
    public Automobile()
    {
        model = "unknown";
    }
    public Automobile(String name, double gallons)
    {
        model = name;
        setGallons(gallons);
    }
    public Automobile(String name, int miles, double gallons)
    {
        model = name;
        setGallons(gallons);
        setMiles(miles);
    }
    //mutators, change the values

    public Automobile setModel(String model) {
        this.model = model;
        return this;
    }

    public Automobile setGallons(double gallons)
    {
        if (gallons < 0)
        {
            System.out.println("Can't be negative");
            gallonsOfGas = 0;
        }
        else {
            this.gallonsOfGas = gallons;
        }
        return this;
    }

    public Automobile setMiles(int miles)
    {
        if (miles < 0)
        {
            milesDriven = 0;
            System.out.println("Are you driving backwards?");
        }
        else {
            this.milesDriven = miles;
        }
        return this;
    }
    public String getModel()
    {
        return model;
    }
    public int getMiles()
    {
        return milesDriven;
    }
    public double getGallons() {
        return gallonsOfGas;
    }
    public String toString()
    {
        String carInfo = "The model is " + model + ", the miles driven is " + milesDriven + ", the gallons left is " + gallonsOfGas;
        return carInfo ;
    }
     public boolean equals(Object o)
     {if( o instanceof Automobile)
     {
         Automobile auto2 = (Automobile) o;
         return (toString().equals(o.toString()));
     }
     else
     {
         System.err.println("That ain't a car");
         return false;
     }
     }
}
