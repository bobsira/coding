package bytebybyte.string;

public class CountOccurrence {

    public static int count(String s, char c){
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c)
                count = count + 1;
        }
        return count;
    }
}
