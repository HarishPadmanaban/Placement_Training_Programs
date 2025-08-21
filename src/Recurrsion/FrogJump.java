package Recurrsion;

import java.util.ArrayList;
import java.util.*;

public class FrogJump {
    public static void main(String[] args) {
        int arr[] = {0,1,2,5,6,9,10,12,13,14,17,19,20,21,26,27,28,29,30};
        Set<String> memo = new HashSet<>();
        System.out.println(jump(arr,0,1,memo));
    }

    public static boolean jump(int arr[], int ind, int k, Set<String> memo) {
        if (ind == arr.length-1) return true;
        String state = ind + "," + k;
        if (memo.contains(state)) return false;

        for (int i = ind+1; i < arr.length; i++) {
            int diff = arr[i] - arr[ind];
            if (diff < k-1) continue;
            if (diff > k+1) break;
            if (jump(arr, i, diff, memo)) return true;
        }

        memo.add(state);
        return false;
    }

}
