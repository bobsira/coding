package bytebybyte.sorting;

public class BinarySearch {

    private static int binarySearch(int[] A, int n , int x){
        int low = 0;
        int high = n - 1;
        while (low <= high){
            int mid =  low + (high - low) / 2;
            if (x == A[mid]) return mid;
            else if (x < A[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] A, int low, int high, int x){
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (x == A[mid]) return mid;
        else if( x < A[mid]) return binarySearchRecursive(A,low,mid-1,x);
        else return binarySearchRecursive(A,mid+1,high,x);
    }
}
