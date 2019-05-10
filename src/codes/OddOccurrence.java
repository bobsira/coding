package codes;/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class OddOccurrence {

    static int getOddOccurrence(int arr[], int arr_size) {
        for (int i = 0; i < arr_size; i++) {
            int count = 0;
            for (int j = 0; j < arr_size; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                return arr[i];
            }
        }
        return 0;
    }

    static int getOddOccurrenceHashMap(int arr[], int arr_size){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr_size; i++){
            if (map.containsKey(arr[i])){
                int val = map.get(arr[i]);
                map.put(arr[i], val + 1);
            }else{
                map.put(arr[i], 1);
            }
        }

        for(Integer a: map.keySet()){
            if (map.get(a) % 2 != 0 ){
                return a;
            }
        }
        return  0;
    }

    static int getOddOccurrenceBit(int arr[], int arr_size){
        int result = 0;
        for (int i = 0; i < arr_size; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

    static int getOddOccurrenceHashSet(int arr[], int arr_size){
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr_size; i++) {
            if (set.contains(arr[i])){
                set.remove(arr[i]);
            }else {
                set.add(arr[i]);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] intArray = new int[N];
            for (int j = 0; j < N; j++) {
                intArray[j] = scanner.nextInt();
            }
            System.out.println(getOddOccurrenceBit(intArray, N));
        }
    }

}