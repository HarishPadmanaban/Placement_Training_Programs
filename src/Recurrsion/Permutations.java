package Recurrsion;

import java.util.*;
public class Permutations {
    public static void main(String[] args) {
        System.out.println(Permutate("","abcd"));
    }
    static ArrayList<String> Permutate(String p,String up)
    {
        if(up.isEmpty())
        {
            ArrayList<String> al = new ArrayList<>();
            al.add(p);
            return al;
        }
        ArrayList<String> ans = new ArrayList<>();
        char c = up.charAt(0);
        for (int i = 0; i <=p.length() ; i++) {
            String f = p.substring(0,i);
            String l = p.substring(i,p.length());
            ans.addAll(Permutate(f+c+l,up.substring(1)));
        }
        return ans;
    }
}
