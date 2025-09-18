package PresumHashMapPattern;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
       // int arr [] = {3,4,7,-2,2,1,4,2};
        int arr[] = {1, 1, 0, 0, 0, 1, 1};
        //[0, 1, 0, 0]
        //1
        //[0,0,0,0,0]   0
        int k = 4;
        System.out.println(findCount(arr,k));
        System.out.println(findCountOptimal(arr,k));
    }

    //https://leetcode.com/problems/continuous-subarray-sum/solutions/5276981/prefix-sum-hashmap-patterns-7-problems
    // Important Pattern

    private static int findCountOptimal(int[] arr, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int diff = prefixSum - k;
            if(map.containsKey(diff))
            {
                count+= map.get(diff);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }

    private static int findCount(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if(sum==k) count++;
            }
        }
        return count;
    }
}
