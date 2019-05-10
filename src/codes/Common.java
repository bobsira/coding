package codes;

public class Common {

    // PALINDROME
    public static boolean isPalindromeRecursive(String string){
        String string_reverse = reverse(string);
        if (string.equals(string_reverse)) return true;
        return false;
    }
    public static String reverse(String string){
        if (string == null || string.isEmpty()) return string;
        return string.charAt(string.length() - 1) + reverse(string.substring(0,string.length()-1));
    }
    public static boolean isPalindromeIterative(String string){
        int low = 0, high = string.length() - 1;
        while (high > low){
            if (string.charAt(low) != string.charAt(high) ) return false;
            low = low + 1;
            high = high - 1;
        }
        return true;
    }
    public static boolean isPalindromeSystem(String string){
        //return string.equals(new StringBuilder(string).reverse().toString());
        return string.equals(new StringBuffer().append(string).reverse().toString());
    }

    //REMOVE ALL OCCURRENCES OF A CHARACTER IN A STRING
    public static String removeCharacter(String string, char unwanted_character){
        StringBuilder new_string = new StringBuilder();
        char[] letters = string.toCharArray();
        for (char character : letters){
            if (character != unwanted_character)
                new_string.append(character);
        }
        return new_string.toString();
    }


    public static void main(String[] args) {
        System.out.println(removeCharacter("geeksforgeeks",'e'));
    }
}
