package PresumHashMapPattern;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int arr[] = {2,-5,-2,-4,3};
        System.out.println(maxSubarray(arr));
    }
    //Similar to prefix and suffix prod ques
    private static int maxSubarray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int p = 1;
        int s = 1;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(p==0) p = 1;
            if(s==0) s = 1;
            p *= arr[i];
            s *= arr[n-1-i];
            max = Math.max(max,Math.max(p,s));
        }
        return max;
    }
}
