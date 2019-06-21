package bytebybyte.array;

public class TopThreeMax {

    static void printTopThreeMax(int[] array){
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i ++){
            if (array[i] > first){
                third = second;
                second = first;
                first = array[i];
            } else if (array[i] > second){
                third = second;
                second = array[i];
            } else if (array[i] > third)
                third = array[i];
        }

        System.out.println(first + " " + second + " " + third);
    }
}
