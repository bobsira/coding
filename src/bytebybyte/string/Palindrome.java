package bytebybyte.string;

public class Palindrome {

    // 1. CHECK PALINDROME
    static boolean isPalindrome(char[] word){
        int i = 0, j = word.length -1;
        while (i < j){
            if (word[i] != word[j])
                return false;
        i = i + 1;
        j = j - 1;
        }
        return true;
    }
    static boolean isPalindromeTwo(String word){
        //return word.equals(new StringBuilder(word).reverse().toString());
        return word.equals(new StringBuffer().append(word).reverse().toString());
    }

    // 2. PALINDROME PERMUTATION
    static boolean isPermutationOfPalindrome(String word){
        int[] table = buildFrequencyTable(word);
        return checkMaxOneOdd(table);
    }
    static int[] buildFrequencyTable(String word){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : word.toCharArray()){
            int x = getCharNumber(c);
            if (x != -1)
                table[x]++;
        }
        return table;
    }
    static boolean checkMaxOneOdd(int[] table){
        boolean found = false;
        for(int count : table){
            if (count % 2 != 0){
                if (found)
                    return false;
                found = true;
            }
        }
        return true;
    }
    static int getCharNumber(Character character){
        /*Map each character to a number a -> 0, b -> 1, c -> 2
        * This is case insensitive. Non-letter characters map to -1
        * */
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int value = Character.getNumericValue(character);
        if (a <= value && value <= z)
            return value - a;
        return -1;
    }
}
