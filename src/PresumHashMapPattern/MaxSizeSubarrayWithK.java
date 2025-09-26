package PresumHashMapPattern;

import java.util.HashMap;

public class MaxSizeSubarrayWithK {
    public static void main(String[] args) {
        int [] arr = {5, 18, -14, 2, 4, 12};
        int k = 15;
        System.out.println(maxSize(arr,k));
    }

    private static int maxSize(int[] arr, int k) {
        int sum = 0;
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int diff = sum-k;
            if(map.containsKey(diff))
            {
                int ind = map.get(diff);
                max = Math.max(max,i-ind+1);
            }
            else{
                map.put(sum,i);
            }
        }
        return max;
    }
}
