package PresumHashMapPattern;

import java.util.HashMap;

public class SubarraySumDivByK {
    public static void main(String[] args) {
        int arr[] = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(findCount(arr,k));
    }

    private static int findCount(int[] arr, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int diff = prefixSum % k;
            if(diff<0) diff+=k;
            if(map.containsKey(diff))
            {
                count+= map.get(diff);
            }
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return count;
    }
}
