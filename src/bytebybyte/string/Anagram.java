package bytebybyte.string;

public class Anagram {

    public static boolean isAnagram(String first, String second){
        if (first.length() != second.length()) return false;

        first = first.toLowerCase();
        second = second.toLowerCase();

        int[] letters =  new int[256];

        for (char c : first.toCharArray())
            letters[c]++;

        for (char c: second.toCharArray())
            letters[c]--;

        for (int letter : letters)
            if (letter != 0)
                return false;

         return true;
    }
}
