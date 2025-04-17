package Recurrsion;

import java.util.*;
public class CombinationSum {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println(Sum("",4));
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
}
