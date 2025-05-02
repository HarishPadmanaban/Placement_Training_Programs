package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PermutationInArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        permutation(arr,new ArrayList<>(),res);
        System.out.println(res);
    }

    public static void permutation(int arr[],List<Integer> ds,List<List<Integer>> res)
    {
        if(ds.size()==arr.length)
        {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] != -100)
            {
                int val = arr[i];
                ds.add(val);
                arr[i] = -100;
                permutation(arr,ds,res);
                arr[i] = val;
                ds.remove(ds.size()-1);
            }
        }
    }
}
