package bytebybyte.string;

public class IsRotation {

    static boolean isRotation(String s1, String s2){
        int length = s1.length();

        if (length == s2.length() && length > 0){
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    /*CHECK THIS LATER WHEN YOU HAVE TIME*/
    public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
