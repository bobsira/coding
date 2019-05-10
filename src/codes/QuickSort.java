package codes;

public class QuickSort {

    int partition(int[] arr, int low, int high){
        int pivot = high;
        int i = (low - 1); //index of smallest element
        for (int j = low; j < high; j++) {
            //if current element is smaller than or equal to pivot
            if (arr[j] <= pivot){
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap arr[i+1] and arr[high] pivot
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    //arr[] --> array to be sorted
    //low --> starting index
    //high --> ending index
    void quickSort(int[] arr, int low, int high){
        if (low < high){
            //pivot is partitioning index, arr[pivot] is now at right place
            int pivot = partition(arr,low,high);
            //recursively sort elements before partition and after partition
            quickSort(arr,low, pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    static int _partition(int[] A, int start, int end){
        int pivot = A[end];
        int pIndex = start;
        for (int i = start; i < end; i++){
            if (A[i] <= pivot){
                int temp = A[i];
                A[i] = A[pIndex];
                A[pIndex] = temp;
                pIndex = pIndex + 1;
            }
        }

        int temp = A[pIndex];
        A[pIndex] = A[end];
        A[end] = temp;
        return pIndex;
    }
    static void _quickSort(int[] A, int start, int end){
        if (start < end){
            int pIndex = _partition(A,start,end);
            _quickSort(A,start,pIndex-1);
            _quickSort(A,pIndex + 1, end);
        }
    }

    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

//        codes.QuickSort ob = new codes.QuickSort();
//        ob.quickSort(arr, 0, n-1);

        _quickSort(arr,0,n-1);

        System.out.print("sorted array --->  ");
        printArray(arr);
    }
}
