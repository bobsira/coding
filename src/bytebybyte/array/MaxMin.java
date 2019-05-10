package bytebybyte.array;

public class MaxMin {

    static void maxMin(int[] array){
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;

        for (int element: array)
            if (element > maximum)
                maximum = element;
            else if (element < minimum)
                minimum = element;
        System.out.println("max -> " + maximum + " min -> " + minimum);
    }
}
