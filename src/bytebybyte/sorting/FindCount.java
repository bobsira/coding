package bytebybyte.sorting;

public class FindCount {

    private static int findCount(int[] A, int n, int x, boolean firstSearch){
        int low = 0;
        int high = n - 1;
        int result = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (x == A[mid]){
                result = mid;
                if (firstSearch) high = mid - 1;
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
        if (first != -1 ){
            int last = findCount(arr,arr.length,10,false);
            System.out.println(last - first + 1);
        }
    }
}
