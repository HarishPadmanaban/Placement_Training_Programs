import java.util.*;

public class Patterns {
    public static void main(String[] args) {
//        int n = 4;
//        int p = 1;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < ((2*n)-1); j++) {
//                if((j+i == n-1))
//                {
//                    System.out.print("*".repeat(p));
//                }
//                else{
//                    System.out.print(" ");
//                }
//            }
//            p+=2;
//            System.out.println();
//        }
//        p-=4;
//        n-=1;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < ((2*n)-1); j++) {
//                if((j-i == 1))
//                {
//                    System.out.print("*".repeat(p));
//                }
//                else{
//                    System.out.print(" ");
//                }
//            }
//            p-=2;
//            System.out.println();
//        }
//        for (int i = 0; i < (2*n)-1; i++) {
//            for (int j = 0; j < (2*n); j++) {
//                if(i<=n-1 && j+i == n-1)
//                {
//                    System.out.print("* ".repeat(p));
//                    //if(i==n-1) p-=2;
//                    break;
//                }
//                else if(i>=n && i-j == n-1)
//                {
//                    //System.out.println(i-j+" "+(n-1));
//                    System.out.print("* ".repeat(p));
//                    break;
//                }
//                else{
//                    System.out.print("  ");
//                }
//            }
//            if(i<n-1) p+=2;
//            else p-=2;
//            System.out.println();
//        }

        lookAndSay(7);

    }
    public static void lookAndSay(int n)
    {
        //n = 5;

        List<Integer> prev = new ArrayList<>(Arrays.asList(1));
        //System.out.println(prev);
        print(prev);
        for(int k=1;k<n;k++)
        {
            List<Integer> res = new ArrayList<>();
            int i = 0;
            while(i<prev.size())
            {
                int element = prev.get(i);
                int count = 1;
                while(i<prev.size()-1 && element==prev.get(i+1))
                {
                    count++;
                    i++;
                }
                res.add(count);
                res.add(element);
                i++;
            }
            //System.out.println(res);
            print(res);
            prev.clear();
            prev.addAll(res);
        }
    }
    public static void print(List<Integer> res)
    {
        for(int i =0;i<res.size();i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    }
}
