import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int row = 7;
        int col = 4;
        //System.out.println(valueOfRowAndCol(row-1,col-1));
        //System.out.println(printRow(7));
        System.out.println(printAll(8));
    }
    public static int valueOfRowAndCol(int r,int c)
    {
        int numerator = 1;
        int denominator = 1;
        for(int i=0;i<c;i++)
        {
            numerator *= (r-i);
            denominator *= (c-i);
        }
        return numerator/denominator;
    }
    public static List<Integer> printRow(int n)
    {
        List<Integer> ans = new ArrayList<>();
        int res = 1;
        ans.add(res);
        for(int i=1;i<n;i++)
        {
            res *= (n-i);
            res /= (i);
            ans.add(res);
        }
        return ans;
    }
    public static List<List<Integer>> printAll(int n)
    {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            List<Integer> a = new ArrayList<>();
            int res = 1;
            a.add(res);
            for(int j=1;j<i;j++)
            {
                res *= (i-j);
                res /= (j);
                a.add(res);
            }
            ans.add(a);
        }
        return ans;
    }
}
