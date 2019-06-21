package bytebybyte.string;

public class IsUnique {
    private static boolean isUnique(String string){
        if (string.length() > 256) return false; //extended ASCII
        boolean [] character_set = new boolean[256];
        for (int i = 0; i < string.length(); i++){
            int value =  string.charAt(i);
            if (character_set[value])
                return false;
            else
                character_set[value] = true;
        }
        return true;
    }
}
