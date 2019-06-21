package bytebybyte.string;

public class Palindrome {

    private static boolean isPalindrome(char[] word){
        int i = 0, j = word.length -1;
        while (i < j){
            if (word[i] != word[j])
                return false;
        i = i + 1;
        j = j - 1;
        }
        return true;
    }

    //STRING INSTEAD OF CHAR ARRAY
    private static boolean isPalindromeIterative(String string){
        int low = 0, high = string.length() - 1;
        while (high > low){
            if (string.charAt(low) != string.charAt(high) ) return false;
            low = low + 1;
            high = high - 1;
        }
        return true;
    }

    private static boolean isPalindromeTwo(String word){
        //return word.equals(new StringBuilder(word).reverse().toString());
        return word.equals(new StringBuffer().append(word).reverse().toString());
    }

    private static boolean isPalindromeRecursive(String string){
        String string_reverse = reverse(string);
        if (string.equals(string_reverse)) return true;
        return false;
    }

    private static String reverse(String string){
        if (string == null || string.isEmpty()) return string;
        return string.charAt(string.length() - 1) + reverse(string.substring(0,string.length()-1));
    }


}
