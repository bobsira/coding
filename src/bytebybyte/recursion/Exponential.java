package bytebybyte.recursion;

public class Exponential {

    private static int exponential(int x, int n){
        if (n == 0) return 1;
        if (n % 2 == 0){
            int y = exponential(x, n / 2 );
            return y * y;
        } else return x * exponential(x , n - 1);
    }

    private static int exponentialInEfficient(int x , int n){
        if ( n == 0) return 1;
        else return x * exponentialInEfficient(x, n -1);
    }

    private static int exponentialIterative(int x, int n){
        int result = x;
        for (int i = 1 ; i < n; i++)
            result = result * x;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(exponential(5,3));
    }
}
