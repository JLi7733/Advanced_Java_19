public class Height {
    private int feet;
    private int inches;
    public Height(int ft, int in){
        feet = ft;
        inches = in;
        simplify();
    }
    public Height(int in){
        inches = in;
        simplify();
    }

    public void simplify(){
        if (inches >= 12){
            feet = feet + inches/12;
            inches = inches % 12;
        }
    }

    public int getFeet() {
        return feet;
    }

    public int getInches() {
        return inches;
    }

    public void add(int in){
        inches = in + inches;
        simplify();
    }
    public void add(Height ht){
        feet = feet + ht.getFeet();
        inches = inches + ht.getInches();
        simplify();
    }
}
