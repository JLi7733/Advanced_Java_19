import java.util.Arrays;

/*
Jonathan Li
Sorts arrays using different methods.
4/3/19
 */
public class SortingArrays {
    // Selection sort
    public static void Selection(int array[])
        {
            int n = array.length;

            for (int i = 0; i < n-1; i++)
            {
                int maximum = i;
                for (int j = i+1; j < n; j++) {
                    if (array[j] > array[maximum])
                        maximum = j;
                }

                int temp = array[maximum];
                array[maximum] = array[i];
                array[i] = temp;
            }
            //prints results
            for(int i = 0;i <array.length;i++) {
            System.out.println( array[i]);
        }
    }
    /*Function to sort array using insertion sort*/
    public static void insertion(int array[])
    {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int temp = array[i];
            int j = i - 1;
            while (j != 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
        //prints results
        for(int i = 0;i <array.length;i++) {
            System.out.println(array[i]);
        }
    }
    public static int[] bubble(int[] array)
    {
        boolean oof = true;
        do {
            int n = array.length - 1;
            for (int i = 0; i < n; i++) {
                int temp = 0;
                if (array[i] < array[i + 1]) {
                    array[i] = temp;
                    array[i] = array[i + 1];
                    array[i + 1] = array[i];
                }
                else
                    oof = false;
            }
        } while(oof);
        //prints results
        for(int i = 0;i <array.length;i++) {
            System.out.println(array[i]);}
        return array;
    }
    public static void split(int[] array)
    {
        int mid = (array.length)/2;
        int n = array.length;
        if(n < 2) {
            return;
        }
        else{
            //splits the array
            int[] firstHalf = new int[mid];
            int[] secondHalf = new int[array.length-mid];
            //Inserts in the values
            for (int i = 0; i < mid - 1; i++) {
                firstHalf[i] = array[i];
            }
            for (int i = n/2; i < array.length-mid; i++) {
                secondHalf[i] = array[i];
                //Continues splitting
                split(firstHalf);
                split(secondHalf);
                merge(array, firstHalf, secondHalf);
            }

        }
        //prints results
        for(int i = 0;i <array.length;i++) {
            System.out.println(array[i]);}
    }
    public static int[] merge(int[] array, int[] firstHalf, int[] secondHalf)
    {
        int i = 0, j = 0, k=0;
        while(i<firstHalf.length && j<secondHalf.length)
        {
            //if the value in the first array is greater, put that in
            if(firstHalf[i]<secondHalf[j])
            {
                array[k] = firstHalf[i];
                i++;
                k++;
            }
            // if the second value is greater
            else
            {
                array[k] = secondHalf[j];
                k++;
                j++;
            }
        }
        while(i<firstHalf.length)
        {
            array[k] = firstHalf[i];
            i++;
            k++;
        }

        while(j<secondHalf.length)
        {
            array[k] = secondHalf[j];
            j++;
            k++;
        }
        //prints results
        for(int p = 0;p <array.length;p++) {
            System.out.println(array[p]);}
        return array;
    }
    public static void main(String[] args) {
        int [] test = new int[]{3,7,11,5};
        int [] test2 = new int[]{-6,100,4,9};
        SortingArrays.Selection(test);
        SortingArrays.insertion(test2);
        test = SortingArrays.bubble(test);
        SortingArrays.split(test2);
    }

}
