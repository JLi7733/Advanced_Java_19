public class HorseBarn
{
    private int stables;
    private Horse[] spaces;
    public HorseBarn()
    {
        stables = 1;
        spaces = new Horse[stables];
    }
    public HorseBarn(int numOfstables)
    {
        stables = numOfstables;
        spaces = new Horse[stables];
    }

    public void setName(String newName, int stable)
    {
        if(stable-1 <= spaces.length)
        {
            spaces[stable-1] = new Horse(newName);
        }
        else
            System.err.println("That is not a valid stable number ");
    }
    public String getName(int i)
    {
        if(i<spaces.length)
        return spaces[i].getName();
        else
            return "Not a valid stable number";
    }

    public int getStables() {
        return stables;
    }

    public int findHorse(String name)
    {
        int horseIndex = 0;
        for(int i =0; i<spaces.length;i++)
        {
            if(name.equals(spaces[i].getName()))
            {
                horseIndex = i;
            }
            else
                horseIndex = -1;
        }
        return horseIndex;
    }
}
