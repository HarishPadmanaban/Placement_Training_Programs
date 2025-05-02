package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsWithRecurrsion {
    public static void main(String[] args) {
        int arr[] = {4,4,4,1,4};
        List<List<Integer>> ans = new ArrayList<>();
        subSets(arr,0,new ArrayList<>(),ans);
        System.out.println(ans);
    }

    static void subSets(int arr[], int ind, List<Integer> ds,List<List<Integer>> ans)
    {
        if(ind==arr.length)
        {
            if(!ans.contains(ds))
                ans.add(new ArrayList<>(ds));
            return;
        }
        subSets(arr,ind+1,ds,ans);
        ds.add(arr[ind]);
        subSets(arr,ind+1,ds,ans);
        ds.remove(ds.size()-1);
    }
}
