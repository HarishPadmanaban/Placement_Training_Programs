package BinarySearch;

public class SmallestDivisor {
    public static void main(String[] args) {
        int [] arr = {44,22,33,11,1};
        int t = 9;
        System.out.println(smallestDivisor(arr,t));
    }

    private static int smallestDivisor(int[] arr, int t) {
        int min = Integer.MAX_VALUE;
        int l = 1;
        int r = -1;
        for(int n : arr) r = Math.max(r,n);
        while(l<=r){
            int mid = l+(r-l)/2;
            if(findDivSum(arr,mid,t)){
                min = Math.min(min,mid);
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return min;
    }

    private static boolean findDivSum(int[] arr, int mid,int t) {
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            c += Math.ceil((double)arr[i]/(double)mid);
        }
        return c<=t;
    }
}
