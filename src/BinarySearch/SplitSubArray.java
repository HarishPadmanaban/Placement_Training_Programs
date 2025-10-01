package BinarySearch;

public class SplitSubArray {
    public static void main(String[] args) {
        int[] arr = {1,4,4};
        int k = 3;
        System.out.println(findMaxSum(arr,k));
    }

    private static int findMaxSum(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        int l = 1;
        int r = 0;
        for (int num : arr) r += num;
        while(l<=r)
        {
            int mid = l +(r-l)/2;
            int sum = findSum(arr,mid);
            if(sum<=k){
                min = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return min;
    }

    private static int findSum(int[] arr, int mid) {
        int count = 1;
        int sum = 0;
        for (int num : arr)
        {
            if(num > mid) return Integer.MAX_VALUE;
            if(sum+num > mid){
                count++;
                sum = num;
            }
            else{
                sum = sum+num;
            }
        }
        return count;
    }
}
