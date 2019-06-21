package bytebybyte.string;

import java.util.Arrays;

public class CheckPermutation {

    private static String sort(String string){
        char[] characters = string.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }
    private static boolean checkPermutation(String first, String second){
        if (first.length() != second.length()) return false;
        return sort(first).equals(sort(second));
    }

    private static boolean checkPermutationEff(String first, String second){
        if (first.length() != second.length()) return false;

        int[] char_set = new int[256];
        for (int i = 0; i < first.length(); i++)
            char_set[first.charAt(i)]++;

        for (int i = 0; i < second.length(); i++){
            char_set[second.charAt(i)]--;
            if (char_set[second.charAt(i)] < 0 ) return false;
        }

        return true;
    }
}
