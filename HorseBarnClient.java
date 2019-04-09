public class HorseBarnClient {
    public static void main(String[] args) {
        HorseBarn first = new HorseBarn(6);
        first.setName("Suarez", 2);
        HorseBarn second = new HorseBarn(4);
        second.setName("Maria", 4);
        HorseBarn third = new HorseBarn(9);
        third.setName("Java", 7);
        HorseBarn[] array = new HorseBarn[]{first, second, third};
        if(first.getStables()>second.getStables())
        {
            if (first.getStables()>third.getStables())
                System.out.println("The first barn is the biggest");
            else
                System.out.println("The third is the greatest");
        }
        else
            System.out.println("The second is the greatest");
    }
}
