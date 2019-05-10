package bytebybyte.string;

public class Compression {

    //BAD 0(P + K^2) P -> SIZE OF ORIGINAL STRING, K -> NUMBER OF CHARACTER SEQUENCE
    //STRING CONCATENATION OPERATES IN 0(N^2)
    public static String compressBad(String string){
        String compressedString = "";
        int count = 1;

        for (int i = 0; i < string.length() - 1; i ++){
            if (string.charAt(i) == string.charAt(i + 1)){
                count = count + 1;
            } else {
                compressedString = compressedString + string.charAt(i) + count;
                count = 1;
            }
        }

        compressedString = compressedString + string.charAt(string.length() -1 ) + count;
        return compressedString.length() < string.length() ? compressedString : string ;
    }

    public static String compress(String string){
        int count = 1;
        StringBuilder compressedString = new StringBuilder();

        for (int i = 0; i < string.length() -1; i++){
            if (string.charAt(i) == string.charAt(i + 1))
                count = count + 1;
            else {
                compressedString.append(string.charAt(i));
                compressedString.append(count);
                count = 1;
            }
        }
        compressedString.append(string.charAt(string.length() -1));
        compressedString.append(count);

        return compressedString.length() < string.length() ? compressedString.toString() : string;
    }

}
