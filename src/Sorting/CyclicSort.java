package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
     int arr[] = {1,2,0};
     //sort(arr);
        // miss(arr);
     System.out.println(missingNum(arr,arr.length));
     System.out.println(Arrays.toString(arr));
    }
    public static void sort(int arr[])
    {
        int i=0;
        while(i<arr.length)
        {
            if((i+1)==arr[i])
            {
                i++;
            }
            else
            {
                swap(arr,i,arr[i]-1);
            }
        }
    }
    public static void swap(int arr[],int s,int d)
    {
        int t = arr[s];
        arr[s] = arr[d];
        arr[d] = t;
    }
    public static int missingNum(int arr[],int n)
    {
        int i=0;
        while(i<arr.length)
        {
            int correct = arr[i]-1;
            if(arr[i]>0 && arr[i]<=arr.length && arr[i]!=arr[correct])
            {
                swap(arr,i,correct);
            }
            else
            {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=(j+1))
                    return j+1;
        }
        return n+1;
    }
    public static void miss(int arr[])
    {
        int i=0;
        ArrayList<Integer> al = new ArrayList<>();
        while(i<arr.length)
        {
            if((i+1)!=arr[i])
            {
                if(arr[i]!=arr[arr[i]-1])
                    swap(arr,i,arr[i]-1);
                else {
                    i++;
                }
            }
            else
            {
                i++;
            }
        }
        for(int j=0;j<arr.length;j++)
        {
            if(j!=arr[j]-1)
            {
                al.add(arr[j]);
            }
        }
        System.out.println(al);
    }
}
