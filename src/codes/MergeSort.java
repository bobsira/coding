package codes;

public class MergeSort {
    // Merge two sub arrays of arr[].
    //First sub array is arr[1..m]
    //Second sub array is arr[m+1..r]
    void merge(int[] arr, int start, int middle, int end){
        int lengthL = middle - start + 1;
        int lengthR = end - middle;

        //create temp arrays
        int[] left = new int[lengthL];
        int[] right = new int[lengthR];

        //Copy data to the temp arrays
        for (int i = 0; i < lengthL; i++)  left[i] = arr[start+i];
        for (int j = 0; j < lengthR; j++) right[j] = arr[middle + 1 + j];

        //merge temp arrays index of the first , second sub array -> merged array
        int i = 0, j = 0 , k = start;
        while (i < lengthL && j < lengthR){
            if (left[i] <= right[j]){ arr[k] = left[i]; i++; }
            else { arr[k] = right[j]; j++;  }
            k++;
        }

        //copy remaining elements
        while (i < lengthL){ arr[k] = left[i]; i++; k++; }
        while (j < lengthR){  arr[k] = right[j]; j++; k++; }
    }

    void sort(int[] arr, int start, int end){
        if (start < end){
            int middle = (end + start) / 2;
            sort(arr,start,middle);
            sort(arr,middle+1,end);
            merge(arr,start,middle,end);
        }
    }



    static void _merge(int[] A, int[] L, int[] R){
        int lengthL = L.length , lengthR = R.length;
        int i = 0, j = 0, k = 0;
        while (i < lengthL && j < lengthR){
            if (L[i] < R[j]){
                A[k] = L[i];  i++;
            } else {
                A[k] = R[j];  j++;
            }
            k++;
        }
        while (i < lengthL){
            A[k] = L[i]; k++; i++;
        }
        while (j < lengthR){
            A[k] = R[j]; k++; j++;
        }

    }
    static void _sort(int[] A){
        int length = A.length;
        if (length < 2) return;
        int middle = length / 2 ;
        int [] L = new int[middle];
        int [] R = new int[length - middle];
        for (int i = 0; i < middle; i++)
            L[i] = A[i];
        for (int i = middle ; i < length; i++)
            R[i - middle] = A[i];
        _sort(L);
        _sort(R);
        _merge(A,L,R);
    }


    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 2, 1, 7};

        System.out.println("Given Array");
        printArray(arr);

//        codes.MergeSort ob = new codes.MergeSort();
//        ob.sort(arr, 0, arr.length-1);
        _sort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
