package bytebybyte.string;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    // 1. GET ALL PERMUTATIONS
    static void permutation(String string){
        printPermutation("", string);
    }
    static void printPermutation(String prefix, String suffix){
        if (suffix.isEmpty()) System.out.println(prefix);
        else {
            for (int i = 0; i < suffix.length(); i++){
                printPermutation(prefix + suffix.charAt(i),
                        suffix.substring(0,i) + suffix.substring(i + 1, suffix.length()));
            }
        }
    }


    static ArrayList<String> permutationList(String string){
        ArrayList<String> results = new ArrayList<>();
        listPermutation("", string, results);
        return results;
    }
    static void listPermutation(String prefix, String suffix, ArrayList<String> results){
        if (suffix.isEmpty()) results.add(prefix);
        else {
            for (int i = 0; i < suffix.length(); i ++){
                listPermutation(prefix + suffix.charAt(i),
                        suffix.substring(0,i) + suffix.substring(i+1, suffix.length()), results);
            }
        }
    }

    static ArrayList<int[]> permutationArray(int [] a){
        ArrayList<int[]> results = new ArrayList<int[]>();
        arrayPermutation(a,0,results);
        return results;
    }
    static void arrayPermutation(int [] a, int start, ArrayList<int[]> results){
        if (start >= a.length)
            results.add(a.clone());
        else {
            for (int i = start; i < a.length; i++){
                swwap(a, start, i);
                arrayPermutation(a, start + 1, results);
                swwap(a,start,i);
            }
        }
    }
    static void swwap(int [] a, int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] =  temp;
    }

    //2. CHECK PERMUTATION
    private static String sortString(String string){
        char[] content= string.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }
    private static boolean checkPermutation(String first, String second){
        if (first.length() != second.length()) return false;
        return sortString(first).equals(sortString(second));
    }

    private static boolean checkPermutation_two(String first, String second){
        if (first.length() != second.length()) return false;
        int letters[] = new int[128]; //ASCII assumption

        System.out.println(Arrays.toString(letters));

//        char first_character[] = first.toCharArray();
//        for (char character: first_character) letters[character]++;
//
//        for (int i = 0; i < second.length(); i++){
//            int character = (int) second.charAt(i);
//            letters[character]--;
//            if (letters[character] < 0) return false;
//        }

        for (int i = 0; i < first.length(); i ++){
            int value = first.charAt(i);
            letters[value]++;
        }

        System.out.println(Arrays.toString(letters));

        for (int j = 0; j < second.length(); j++){
            int value = second.charAt(j);
            letters[value]--;
            if (letters[value] < 0) return false;
        }

        System.out.println(Arrays.toString(letters));
        return true;
    }

    public static void main(String[] args) {
//        ArrayList<int[]> per = new ArrayList<>();
////        int[] elements = {1,2,3};
////        per = permutationArray(elements);
////        for (int i = 0; i < per.size(); i ++){
////            for (int j = 0; j < per.get(i).length; j++) {
////                System.out.print(per.get(i)[j] + " ");
////            }
////            System.out.println();
////        }
    }

}
