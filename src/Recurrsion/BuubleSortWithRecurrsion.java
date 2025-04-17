package Recurrsion;

import java.util.Arrays;

public class BuubleSortWithRecurrsion {
    public static void main(String[] args) {
        int arr[] = {100,3,90,2,5};
        BubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
    static void BubbleSort(int [] arr,int s,int e)
    {
        if(s==0)
        {
            return;
        }
        if(e<s)
        {
            if(arr[e]>arr[e+1])
            {
                int t = arr[e];
                arr[e] = arr[e+1];
                arr[e+1] = t;
            }
            BubbleSort(arr,s,e+1);
        }
        else {
            BubbleSort(arr,s-1,0);
        }
    }
}
