package bytebybyte.array;

public class MaxMin {

    static void maxMin(int[] array){
        // sort nlogn
        // get first abd last o(1)
        // this other algorithm takes n time which is faster than nlogn
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
