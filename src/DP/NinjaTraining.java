package DP;

public class NinjaTraining {
    public static void main(String[] args) {
        int [][]arr = {{10,50,1},
                        {5,100,11}};
        int [][]dp = new int[arr.length][4];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
            dp[i][3] = -1;
        }
        System.out.println(maxPointsRecurrsion(arr,0,-1));
        System.out.println(maxPointsMemoization(arr,0,3,dp));
    }

    private static int maxPointsMemoization(int[][] arr, int ind, int prev,int[][] dp) {
        if (ind == arr.length) return 0;

        if(dp[ind][prev]!=-1) return dp[ind][prev];

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if(i!=prev)
            {
                int points = arr[ind][i] + maxPointsMemoization(arr,ind+1,i,dp);
                max = Math.max(max,points);
            }
        }
        return dp[ind][prev] = max;
    }

    private static int maxPointsRecurrsion(int[][] arr,int ind , int prev) {
        if (ind == arr.length) return 0;
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if(i!=prev)
            {
                int points = arr[ind][i] + maxPointsRecurrsion(arr,ind+1,i);
                max = Math.max(max,points);
            }
        }
        return max;
    }
}
