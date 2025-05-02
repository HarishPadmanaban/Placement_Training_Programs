package ZohoPractiseProblem;

import java.util.Arrays;

public class MaxRight {
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        System.out.println(Arrays.toString(maximumRight(arr)));
    }
    public static int[] maximumRight(int arr[])
    {
        int [] res = new int[arr.length];
        res[arr.length-1] = -1;
        int max = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--)
        {
            res[i] = max;
            max = Math.max(max,arr[i]);

        }
        return res;
    }
}
