package bytebybyte.array;

import java.util.HashSet;

public class CheckAbsent {

    static int checkAbsent(int[] arr_one, int[] arr_two){
        /*check which number is not present in the second array*/
        HashSet<Integer> hashSet = new HashSet<>();

        for (int element: arr_two)
            hashSet.add(element);

        for (int element: arr_one){
            if (!hashSet.contains(element))
                return element;
        }
        return -1;
    }
}
