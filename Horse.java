public class Horse {
    private String name;
    public Horse()
    {
        name = "";
    }
    public Horse(String newName)
    {
        name = newName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
