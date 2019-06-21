package bytebybyte.sorting;

public class FirstOccurrence {

    private static int firstOccurrence(int[] A, int n , int x){
        int low = 0;
        int high = n - 1;
        int result = -1;
        while (low <= high){
            int mid = low + ( high - low ) / 2;
            if (x == A[mid]){
                result = mid;
                high = mid - 1;  //low = mid + 1 for last occurrence
            }
            else if (x < A[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return result;
    }


}
