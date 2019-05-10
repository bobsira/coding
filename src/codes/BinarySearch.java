package codes;

public class BinarySearch {

    static int BSearch(int[] A, int n, int x){
        int low = 0;
        int high = n - 1;

        while (low<= high){
            int mid = (low + high) / 2;
            if (x == A[mid]) return mid;
            else if (x < A[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    static int BSearchR(int[] A, int low, int high, int x){
        if (low > high) return  -1;
        int mid = low + (high - low) /2;
        if (x == A[mid]) return mid;
        else if (x < A[mid]) return BSearchR(A,low,mid -1, x);
        else return BSearchR(A,mid+1,high,x);
    }

    static int firstOccurrence(int[]A, int n, int x){
        int low = 0, high = n - 1, result = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (x == A[mid]){
                result = mid;
                high = mid -1; // first occurrence
            }
            else if (x < A[mid]) high = mid - 1;
            else  low = mid +1;
        }
        return result;
    }
    static int lastOccurrence(int[] A, int n, int x){
        int low = 0, high = n - 1, result = -1;
        while (low<=high){
            int mid = low + (high - low) / 2;
            if (x == A[mid]){
                result = mid;
                low = mid + 1; // last occurrence
            }
            else if (x < A[mid]) high = mid -1;
            else  low = mid + 1;
        }
        return result;
    }

    static int findCount(int[]A, int n ,int x, boolean firstSearch){
        int low = 0, high = n - 1, result = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (x == A[mid]){
                result = mid;
                if (firstSearch) high = mid -1;
                else low = mid + 1;
            }
            else if (x < A[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 10, 10, 10, 18, 20};
        int first = findCount(arr,arr.length,10,true);
        if (first != -1){
            int last = findCount(arr,arr.length,10,false);
            System.out.println(last - first + 1);
        }
    }
}
