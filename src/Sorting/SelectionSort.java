package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {20};

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int sind = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < val) {
                    val = arr[j];
                    sind = j;
                }
            }
            int temp = arr[i];
            arr[i] = val;
            arr[sind]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
