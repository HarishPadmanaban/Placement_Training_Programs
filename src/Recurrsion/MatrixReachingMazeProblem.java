package Recurrsion;

import java.util.ArrayList;

public class MatrixReachingMazeProblem {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Ways(3,2));
        PrintPath("",3,2);
        System.out.println(ReturnPath("",3,2));
    }
    static int Ways(int r,int c)
    {
        if(r==1||c==1)
            return 1;
        return Ways(r-1,c)+Ways(r,c-1);
    }
    static void PrintPath(String p,int r,int c)
    {
        if(r==1&&c==1)
        {
            System.out.println(p);
            return;
        }
        if(r>1)
            PrintPath(p+"D",r-1,c);
        if(c>1)
            PrintPath(p+"R",r,c-1);
    }

    static ArrayList<String> ReturnPath(String p,int r,int c)
    {
        if(r==1&&c==1)
        {
            ArrayList<String> al = new ArrayList<>();
            al.add(p);
            return al;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r>1)
            ans.addAll(ReturnPath(p+"D",r-1,c));
        if(c>1)
            ans.addAll(ReturnPath(p+"R",r,c-1));
        return ans;
    }
}
