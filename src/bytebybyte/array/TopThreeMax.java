package bytebybyte.array;

public class TopThreeMax {

    static void printTopThreeMax(int[] array){
        int max_one = Integer.MIN_VALUE, max_two = Integer.MIN_VALUE, max_three = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i ++){
            if (array[i] > max_one){
                max_three = max_two;
                max_two = max_one;
                max_one = array[i];
            } else if (array[i] > max_two){
                max_one = max_two;
                max_two = array[i];
            } else if (array[i] > max_three)
                max_three = array[i];
        }

        System.out.println(max_one + " " + max_two + " " + max_three);
    }
}
