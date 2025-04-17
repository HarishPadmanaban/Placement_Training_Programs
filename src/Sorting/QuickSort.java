package Sorting;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    void swap(int arr[],int source,int dest){
        int temp=arr[source];
        arr[source]=arr[dest];
        arr[dest]=temp;
    }
    int partition(int a[],int start,int end)
    {
        int pivot=a[start];
        int i=start;
        int j=end;
        while(i<=j)
        {
            // System.out.print("\n"+a[i]+" "+a[j]+"\n");
            if(pivot>=a[i])
            {
                i++;
            }
            else{
                if(pivot<a[j]){
                    j--;
                }
                else{
                    swap(a, i, j);
                }
            }
        }
        swap(a, start, j);
        return j;
    }
    void quick(int a[],int start,int end)
    {
        if(start<end)
        {
            int p=partition(a,start,end);
            quick(a,start,p-1);
            quick(a,p+1,end);
        }
    }
    public static void main(String args[])
    {
//        Random r=new Random();
//        int n=1000;
//        int arr[]=new int[n];
//        for(int i=0;i<n;i++)
//            arr[i]=r.nextInt(n);
//        System.out.println("Before sorting:");
//        for(int i=0;i<n;i++)
//            System.out.print(arr[i]+" ");
//        long st=System.nanoTime();
//        QuickSort q1=new QuickSort();
//        q1.quick(arr, 0, n-1);
//        long en=System.nanoTime();
//        System.out.println("\nAfter sorting");
//        for(int i=0;i<n;i++)
//            System.out.print(arr[i]+" ");
//        System.out.println("\nThe time taken :"+(en-st));
        int arr[] = {8,3,4,12,5,6};
        QuickSort q1=new QuickSort();
        q1.quick(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

