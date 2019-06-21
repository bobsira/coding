package bytebybyte.recursion;

public class ModularExponentiation {

    private static int modExponentiation(int x, int n, int m){
        if (n == 0) return 1;
        if (n % 2 == 0){
            int y = modExponentiation(x, n/2, m);
            return (y * y) % m;
        } else return ((x % m) * (modExponentiation(x , n -1,  m))) % m;
    }

    public static void main(String[] args) {
        System.out.println(modExponentiation(5,2,7));
        System.out.println(modExponentiation(5,3,7));
    }
}
