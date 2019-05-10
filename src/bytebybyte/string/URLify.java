package bytebybyte.string;

public class URLify {

    static void replaceSpaces(char[] string, int trueLength){

        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++)
            if (string[i] == ' ')
                spaceCount = spaceCount + 1;

        int index = trueLength + spaceCount * 2;
        if (trueLength < string.length) string[trueLength] = '\0';

        for (int i = trueLength - 1; i >= 0; i--){
            if (string[i] == ' '){
                string[index - 1] = '0';
                string[index - 2] = '2';
                string[index - 3] = '%';
                index = index - 3;
            } else  {
                string[index - 1] = string[i];
                index = index - 1;
            }
        }
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, trueLength);
        for (Character character: arr)
            System.out.print(character + "");
    }
}
