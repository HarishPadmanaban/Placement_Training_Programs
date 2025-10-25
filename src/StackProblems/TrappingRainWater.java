package StackProblems;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int arr [] = {0,1,0,2,1,0,1,3,2,1,2,1}; //4,2,0,3,2,5
        System.out.println(totalWater(arr));
        System.out.println(optimizedSolution(arr));
    }

    private static int optimizedSolution(int[] arr) {
        int total = 0 ,leftMax = 0, rightMax = 0;
        int n = arr.length;
        int l = 0, r = n-1;
        while(l<r){ // 0,1,0,2,1,0,1,3,2,1,2,1
            if(arr[l] <= arr[r]){
                if(arr[l]<leftMax)
                    total += leftMax-arr[l];
                leftMax = Math.max(leftMax,arr[l]);
                l++;
            }
            else{
                if(arr[r]<rightMax)
                    total += rightMax - arr[r];
                rightMax = Math.max(rightMax,arr[r]);
                r--;
            }
        }
        return total;
    }

    private static int totalWater(int[] arr) {
        int total = 0;
        int n = arr.length;
        int[] suffixSum = new int[n];
        suffixSum[n-1] = arr[n-1];
        for (int i = n-2; i >=0; i--) {
            suffixSum[i] = Math.max(arr[i],suffixSum[i+1]);
        }
        int prefixMax = arr[0];
        for (int i = 1; i <n ; i++) {
            if(arr[i]<prefixMax && arr[i]<suffixSum[i]){
                total += Math.min(prefixMax,suffixSum[i]) - arr[i];
            }
            prefixMax = Math.max(arr[i],prefixMax);
        }
        return total;
    }
}
