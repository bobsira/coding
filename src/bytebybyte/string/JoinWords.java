package bytebybyte.string;

public class JoinWords {

    private String joinWordsBad(String[] words){
        String sentence = "";
        for (String w: words)
            sentence = sentence + w;
        return sentence;
    }

    private String joinWords(String[] words){
        StringBuilder sentence = new StringBuilder();
        for (String w : words)
            sentence.append(w);
        return sentence.toString();
    }
}
