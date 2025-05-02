package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PowerSetSubsequences {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(powerSet(arr));
    }

    static List<List<Integer>> powerSet(int arr[]) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = (int) Math.pow(2, arr.length);
        for (int i = 0; i < len; i++) {
            List<Integer> al = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) {
                    al.add(arr[j]);
                }
            }
            //System.out.println(al);
            ans.add(al);
        }
        return ans;
    }
}
