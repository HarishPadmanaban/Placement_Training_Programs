package BinarySearch;

public class MBouquet {
    public static void main(String[] args) {
        int[] arr = {1,10,2,9,3,8,4,7,5,6};
        int m = 4;
        int k = 2;
        System.out.println(minDaysToDeliver(arr,m,k));
    }

    private static int minDaysToDeliver(int[] arr, int m, int k) {
        if(m*k > arr.length) return -1;
        int min = Integer.MAX_VALUE;
        int l = 1;
        int r = -1;
        for(int num : arr)
        {
            r = Math.max(r,num);
        }
        while(l<=r)
        {
            int mid = l+(r-l)/2;

            if(isPossible(arr,mid,m,k))
            {
                min = Math.min(min,mid);
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return min;
    }

    private static boolean isPossible(int arr[],int day,int m,int k)
    {
        int count = 0;
        int bo = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<=day){
                count++;
            }
            else{
                bo += count/k;
                count = 0;
            }
        }
        bo += count/k;
        return bo >= m;
    }
}
