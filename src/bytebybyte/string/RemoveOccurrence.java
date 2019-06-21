package bytebybyte.string;

public class RemoveOccurrence {


    /**
     * Remove all occurrences of a character in a string */
    private static String removeCharacter(String string, char unwanted){
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < string.length(); i++)
            if (unwanted != string.charAt(i))
                newString.append(string.charAt(i));
        return newString.toString();
    }
}
