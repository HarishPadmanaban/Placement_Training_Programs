package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class BallsGame {
    public static void main(String[] args) {

        String s = "abc";
        List<String> res = new ArrayList<String>();
        recur("",s,res);
        System.out.println(res);
    }

    static void recur(String p, String up, List<String> res)
    {
        if(up.isEmpty())
        {
            res.add(p);
            return;
        }

        char c = up.charAt(0);
        for(int i=0;i<=p.length();i++)
        {
            String f = up.substring(0,i);
            String l = up.substring(i,p.length());
            recur(f+c+l,up.substring(1),res);
        }
    }
}
