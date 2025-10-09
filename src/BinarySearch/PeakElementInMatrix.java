package BinarySearch;

import java.util.Arrays;

public class PeakElementInMatrix {
    public static void main(String[] args) {
        int [][] arr = {{1,10},{50,500},{40,2},{30,3},{20,4}};
        System.out.println(Arrays.toString(findPeak(arr)));
    }

    private static int[] findPeak(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int l = 0, r = n-1;

        while(l<=r)
        {
            int mid = l+(r-l)/2;
            int max = -1;
            int ind = mid;
            for(int i =0;i<m;i++){
                if(arr[i][mid]>max){
                    ind = i;
                    max = arr[i][mid];
                }
            }
            if((mid==0 || arr[ind][mid-1]<max) && (mid==n-1 || arr[ind][mid+1]<max)){
                return new int[]{ind,mid};
            }
            else if(mid==0 || arr[ind][mid-1]>max){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
