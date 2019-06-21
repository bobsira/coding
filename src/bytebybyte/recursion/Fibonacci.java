package bytebybyte.recursion;

public class Fibonacci {

    private static int fibonacci(int n){
        if (n <= 1 ) return n;
        else return fibonacci( n - 1) + fibonacci(n-  2);
    }

    private static int fibonacciRecursive(int n){
        if (n <= 1) return n;
        int F = 0, f1 = 0, f2 = 1;
        for (int i = 1 ; i < n; i++){
            F = f1 + f2;
            f1 = f2;
            f2 = F;
        }
        return F;
    }

}
