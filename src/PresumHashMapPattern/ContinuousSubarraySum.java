package PresumHashMapPattern;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int arr[] = {23,2,6,4,7};
        int k = 13;
        System.out.println(continuous(arr,k));
        System.out.println(continuousOptimized(arr,k));
    }

    private static boolean continuousOptimized(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int diff = sum-k;
            int val = map.getOrDefault(diff,-1);
            if(diff%k==0 && (i-val+1)>=2)
            {
                return true;
            }
            map.put(sum,i);
        }
        return false;
    }

    private static boolean continuous(int[] arr,int k) {
        for (int i = 0; i < arr.length-1; i++) {
            int sum = arr[i];
            for (int j = i+1; j < arr.length ; j++) {
                sum += arr[j];
                if(sum%k==0) return true;
            }
        }
        return false;
    }


}
