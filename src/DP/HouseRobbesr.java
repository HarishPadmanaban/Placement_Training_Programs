package DP;

public class HouseRobbesr {
    public static void main(String[] args) {
        int arr[] = {2,7,9,3,1};
        int [] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = -1;
        }
        System.out.println(houseRecurssion(arr,arr.length-1,dp));
        System.out.println(houseRobberTabluation(arr,dp));
        System.out.println(houseRobberSpaceOptimization(arr));
    }

    private static int houseRobberSpaceOptimization(int[] arr) {
        int max = arr[0];
        int prev1 = arr[0];
        int prev2 = -1;
        for (int i = 1; i <arr.length ; i++) {
            int take = arr[i] ;
            if(i>1) take+= prev2;
            int notTake = prev1;
            max = Math.max(max,Math.max(take,notTake));
            prev2 = prev1;
            prev1 = max;
        }
        return max;
    }

    private static int houseRobberTabluation(int[] arr, int[] dp) {
        int max = arr[0];
        dp[0] = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            int take = arr[i] ;
            if(i>1) take+= dp[i-2];
            int notTake = dp[i-1];
            max = Math.max(max,Math.max(take,notTake));
        }
        return max;
    }

    private static int houseRecurssion(int[] arr,int ind,int [] dp) {
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int take = arr[ind] + houseRecurssion(arr,ind-2,dp);
        int notTake = houseRecurssion(arr,ind-1,dp);
        return dp[ind]=Math.max(take,notTake);
    }
}
