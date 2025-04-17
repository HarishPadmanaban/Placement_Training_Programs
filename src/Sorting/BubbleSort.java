package Sorting;

import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {20,1,34,5,2,789,8};
        boolean f = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]) {
                    swap(arr, j, j + 1);
                    f = true;
                }
            }
            if(!f)
            {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
    public static void swap(int arr[],int s,int d)
    {
        int t = arr[s];
        arr[s] = arr[d];
        arr[d] = t;
    }
}
