package bytebybyte.sorting;

public class QuickSort {

    private static void quickSort(int[] A, int start, int end){
        if (start < end) {
            int pIndex = partition(A, start, end);
            quickSort(A,start,pIndex - 1);
            quickSort(A,pIndex + 1, end);
        }
    }
    private static int partition(int[] A, int start, int end){
        int pivot = A[end];
        int pIndex = start;
        for (int i = start; i < end; i++){
            if (A[i] <= pivot) {
                int temp = A[pIndex];
                A[pIndex] = A[i];
                A[i] = temp;
                pIndex = pIndex + 1;
            }
        }
        int temp = pivot;
        A[end] = A[pIndex];
        A[pIndex] = temp;
        return pIndex;
    }

    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    public static void main(String args[]) {
        int arr[] = {12, 11, 2,  13, 5, 6, 2, 1, 7, -1};
        int n = arr.length;


        quickSort(arr,0,n-1);

        System.out.print("sorted array --->  ");
        printArray(arr);
    }
}
