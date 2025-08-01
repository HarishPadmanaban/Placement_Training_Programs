package ZohoPractiseProblem;

import java.util.Arrays;

public class AlternateSorting {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        for(int i =0;i<arr.length;i++)
        {
            swap(arr,i);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr,int start)
    {
        int i = start;
        int j = arr.length - 1;
        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
