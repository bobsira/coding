package bytebybyte.sorting;

public class MergeSort {

    private static void sort(int[] A){
        int length = A.length;
        if (length < 2 ) return;
        int middle = length / 2;
        int[] L = new int[middle];
        int[] R= new int[length - middle];
        for (int i = 0; i < middle; i++)
            L[i] = A[i];
        for (int i = middle; i < length; i++)
            R[i - middle] = A[i];
        sort(L);
        sort(R);
        merge(A,L,R);
    }

    private static void merge(int[] A, int[] L, int[] R){
        int lengthL= L.length, lengthR = R.length;
        int i = 0, j = 0 , k = 0;
        while (i < lengthL && j < lengthR){
            if (L[i] < R[j]){
                A[k] = L[i];
                i = i + 1;
                k = k + 1;
            }
            else {
                A[k] = R[j];
                j = j + 1;
                k = k + 1;
            }

        }

        while (i < lengthL){
            A[k] = L[i];
            i = i + 1;
            k = k + 1;
        }

        while (j < lengthR){
            A[k] = R[j];
            j = j + 1;
            k = k + 1;
        }
    }


    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 2,  13, 5, 6, 2, 1, 7, -1};

        System.out.println("Given Array");
        printArray(arr);

        sort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
