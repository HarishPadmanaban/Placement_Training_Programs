import java.util.*;
public class SmallestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int s = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(smallest(s,d));
    }
    public static String smallest(int s,int d)
    {
        if(s==0)
        {
            return (d==1)?"0":"Not posiible";
        }
        if(s>(d*9))
            return "Not possible";
        StringBuffer res = new StringBuffer();
        s-=1;
        for(int i=d-1;i>0;i--)
        {
            if(s>=9)
            {
                res.append(9);
                s-=9;
            }
            else {
                res.append(s);
                s=0;
            }
        }
        res.append(s+1);
        return res.reverse().toString();
    }
}
