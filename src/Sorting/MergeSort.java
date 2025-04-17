package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8,3,4,12,6,5};
        //System.out.println(Arrays.toString(mergeSort(arr)));
        mergeSortInPlace(arr,0,arr.length);
    }

    public static int[] mergeSort(int arr[])
    {
        if(arr.length==1){
            return arr;
        }

        int mid = arr.length/2;
        int first[] = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int second[] = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(first,second);
    }
    public static int[] merge(int first[],int second[])
    {
        int [] res = new int[first.length+second.length];

        int i=0,j=0,k=0;

        while(i < first.length && j < second.length)
        {
            if(first[i]<=second[j])
            {
                res[k++] = first[i++];
            }
            else{
                res[k++] = second[j++];
            }
        }

        while(i<first.length)
        {
            res[k++] = first[i++];
        }
        while(j< second.length)
        {
            res[k++] = second[j++];
        }
        return res;
    }

    public static void mergeSortInPlace(int arr[],int start,int end)
    {
        if((end-start)==1){
            return;
        }

        int mid = (end+start)/2;
        mergeSortInPlace(arr,start,mid);
        mergeSortInPlace(arr,mid,end);
        mergeForInPlace(arr,start,mid,end);
    }

    public static void mergeForInPlace(int arr[],int s,int m,int e)
    {
        int [] res = new int[e-s];

        int i=s,j=m,k=0;

        while(i < m && j < e)
        {
            if(arr[i]<=arr[j])
            {
                res[k++] = arr[i++];
            }
            else{
                res[k++] = arr[j++];
            }
        }

        while(i<m)
        {
            res[k++] = arr[i++];
        }
        while(j< e)
        {
            res[k++] = arr[j++];
        }
        System.out.println(Arrays.toString(res));
        for(int it=0;it<res.length;it++)
        {
            arr[it+s] = res[it];
        }
        System.out.println(Arrays.toString(arr));
    }
}
