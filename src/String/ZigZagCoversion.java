package String;
import java.util.*;

public class ZigZagCoversion {
    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int r = 5;


        List<Character>[] rows = new ArrayList[r];

        int ind =0,t =1;

        for(int i=0;i<r;i++)
        {
            rows[i] = new ArrayList<>();
        }
        for(char c : s.toCharArray())
        {
            rows[ind].add(c);
            if(ind==0)
                t = 1;
            else if(ind==r-1) t = -1;

            ind+=t;
            //System.out.println(Arrays.toString(rows));
        }
        //System.out.println(Arrays.toString(rows));
        StringBuffer sb = new StringBuffer();
        for(List<Character> row : rows)
        {
            for (char c : row)
                sb.append(c);
        }
        System.out.println(sb);
    }
}