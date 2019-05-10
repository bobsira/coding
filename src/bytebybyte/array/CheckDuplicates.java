package bytebybyte.array;

import java.util.HashSet;

public class CheckDuplicates {

    static boolean checkDuplicates(String[] elements){
        HashSet<String> elements_hashset = new HashSet<>();
        for (String element: elements)
            if (!elements_hashset.add(element))
                return true;
        return false;
    }

}
