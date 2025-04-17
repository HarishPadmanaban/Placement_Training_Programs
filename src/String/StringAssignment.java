package String;

import java.util.*;
public class StringAssignment {
    public static void main(String args[])
    {
       Scanner sc =new Scanner(System.in);
       String s1 = "ABCD";
       String s2 = "CDAB";
       if(s1.length()!=s2.length())
       {
           System.out.println("Not a rotation");
           System.exit(0);
       }
       if(s1.equals(s2))
       {
           System.out.println("Rotation");
           System.exit(0);
       }
        for (int i = 0; i < s1.length()-1; i++) {
            String s = s1.substring(i+1,s1.length())+s1.substring(0,i+1);
            //System.out.println(s);
            if(s2.equals(s))
            {
                System.out.println("Rotation");
                break;
            }
        }
    }
}
