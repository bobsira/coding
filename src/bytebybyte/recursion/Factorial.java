package bytebybyte.recursion;

public class Factorial {

    private static int factorial(int n){
        if (n == 0) return 1;
        else return n * factorial(n - 1) ;
    }

    private static int factorialRecursive(int n){
        if (n == 0) return 1;
        int result = n;
        for (int i = 1; i < n; i++)
            result = result * i;
        return result;
    }
}
