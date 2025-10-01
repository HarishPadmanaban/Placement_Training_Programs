package BinarySearch;

public class CapacityPackages {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        //3,2,2,4,1,4
        //System.out.println(minCapacity(arr,days));
        System.out.println(minDays(arr,days));
    }

//    private static int minCapacity(int[] arr, int days) {
//        int cap = -1;
//
//    }

    private static int minDays(int[] arr, int days) {
        int min = Integer.MAX_VALUE;
        int l = 1;
        int r = findSum(arr);
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(isPossible(arr,days,mid)){
                min = Math.min(min,mid);
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return min;
    }

    private static boolean isPossible(int[] arr, int days,int mid)
    {
        int cday = 0;
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>mid) return false;
            if(sum+arr[i]>mid){
                cday++;
                sum=0;
            }
            sum+=arr[i];
        }
        if(sum>0) {
            cday++;
        }
        return cday <= days;
    }

    private static int findSum(int[] arr) {
        int sum = 0;
        for(int n : arr)
        {
            sum += n;
        }
        return sum;
    }
}
