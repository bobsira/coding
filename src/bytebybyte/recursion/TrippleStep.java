package bytebybyte.recursion;

import java.util.Arrays;

public class TrippleStep {

    // BRUTE FORCE
    private static int countWaysBruteForce(int n){
        if (n < 0) return 0;
        else if( n == 0) return 1;
        else return countWaysBruteForce(n - 1) + countWaysBruteForce( n - 2) + countWaysBruteForce( n - 3);
    }

    // MEMOIZATION SOLUTION

    private static int countWays(int n){
        int[] memo = new int[ n + 1];
        Arrays.fill(memo, -1);
        return countWays(n , memo);
    }

    private static int countWays(int n , int[] memo){
        if (n < 0) return 0;
        else if (n == 0) return 1;
        else if (memo[n] > -1 ) return memo[n];
        else {
            memo[n] = countWays(n - 1, memo) + countWays(n -2 , memo) + countWays(n - 3, memo);
            return memo[n];
        }
    }
}
