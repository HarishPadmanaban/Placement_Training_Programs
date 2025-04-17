import java.util.*;
public class Subsequences {
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        String s = "abc";
        char ch[] = s.toCharArray();
        int n = s.length();
        int len = (int)Math.pow(2,n);
       // System.out.println();
        for(int i=0;i<len;i++)
        {
            String res ="";
            for(int j=0;j<n;j++)
            {
                if((i & (1<<j))!=0)
                {
                        res = res+ch[j];
                }
            }
            System.out.println(res);
        }
//        for (int i = 0; i < len; i++) {
//            String res="";
//            for (int j = 0; j < n; j++) {
//                //System.out.println((i & (1<<j)));
//                int val = (i & (1<<j));
//                res = res+val;
//            }
//            System.out.println(res);
//        }
    }
}
