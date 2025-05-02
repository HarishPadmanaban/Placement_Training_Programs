package Recurrsion;

import java.util.*;
public class CombinationSum {
    public static void main(String[] args) {
        int arr[] = {2,3,6,7};
        //System.out.println(Sum("",7));
        List<List<Integer>> ans = new ArrayList<>();
        combination(arr,7,0,new ArrayList<>(),ans);
        System.out.println(ans);
    }
    //static ArrayList<Integer> al = new ArrayList<>();
    static ArrayList<String> Sum(String p,int target)
    {
        if(target==0)
        {
            ArrayList<String> al = new ArrayList<>();
            al.add(p);
            //System.out.println(p);
            return al;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6&&i<=target; i++) {
                ans.addAll(Sum(p+i,target-i));
        }
        return ans;
    }
    static void combination(int arr[],int target,int ind,List<Integer> li,List<List<Integer>> ans)
    {
        if(ind==arr.length)
        {
            if(target==0)
                ans.add(new ArrayList<>(li));
            return;
        }
        if(target==0) {
            ans.add(new ArrayList<>(li));
            return;
        }
        if(arr[ind]<=target)
        {
            li.add(arr[ind]);
            combination(arr,target-arr[ind],ind,li,ans);

            li.remove(li.size()-1);
        }
        combination(arr,target,ind+1,li,ans);
    }

}
