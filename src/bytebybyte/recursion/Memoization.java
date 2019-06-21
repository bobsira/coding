package bytebybyte.recursion;

import java.util.Arrays;

public class Memoization {

    private static int[] F = new int[51];

    private static int fibonacci(int n){
        if (n <= 1) return n;
        if (F[n] != -1) return F[n];
        else F[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return F[n];
    }

    public static void main(String[] args) {
        Arrays.fill(F,-1);
    }
}
