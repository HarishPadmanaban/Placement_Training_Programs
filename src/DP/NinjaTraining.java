package DP;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int arr[][] = {{10,50,1},
                        {5,100,11}};
        System.out.println(maxPointsRecurrsion(arr,0,0));
    }

    private static int maxPointsRecurrsion(int[][] arr,int ind , int prev) {
        if(ind== arr.length) return 0;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if(i!=prev){
                int points = 
                max = Math.max(max , maxPointsRecurrsion(arr,ind+1,i));
            }

        }
        return max;
//        int [][] dp = new int[arr.length][2];
//        for (int i = 0; i <arr.length ; i++) {
//            dp[i][0] = -1;
//            dp[i][1] = -1;
//        }
//        for(int i=0;i<3;i++)
//        {
//            max = Math.max(max , helper1(arr,1,arr[0][i],i,dp));
//        }
//        return max;
    }

    private static int helper1(int[][] arr, int ind,int max,int prev,int[][]dp) {
        if(ind==arr.length) return max;
        for(int[] a : dp){
            System.out.println(Arrays.toString(a));
            System.out.println();
        }
        if(dp[ind][0]!=-1){
            if(prev==dp[ind][0]) return helper1(arr,ind+1,max+arr[ind][dp[ind][1]],dp[ind][1],dp);
            else return helper1(arr,ind+1,max+arr[ind][dp[ind][0]],dp[ind][0],dp);
        }
        int fm = 0;
        int sm = 0;
        for (int i = 1; i < 3; i++) {
            if(arr[ind][i]>arr[ind][fm]){
                sm = fm;
                fm = i;
            }
            else if(arr[ind][i] > arr[ind][sm]){
                sm = i;
            }
        }
        dp[ind][0] = fm;
        dp[ind][1] = sm;
//        if(prev==0){
//            prev = (arr[ind][1]>arr[ind][2]) ? 1 : 2;
//            max+=arr[ind][prev];
//        } else if (prev == 1) {
//            prev = (arr[ind][0]>arr[ind][2]) ? 0 : 2;
//            max+=arr[ind][prev];
//        }
//        else{
//            prev = (arr[ind][0]>arr[ind][1]) ? 0 : 1;
//            max+=arr[ind][prev];
//        }
        return helper1(arr,ind+1,max,prev,dp);
    }
}
