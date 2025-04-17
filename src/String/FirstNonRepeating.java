package String;

import java.util.*;
public class FirstNonRepeating {
    public static void main(String[] args)
    {
        String s = "gibblegabbler";
        int ch[] = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            ch[s.charAt(i)-'a']++;
        }
        System.out.println(Arrays.toString(ch));
        for (int i = 0; i < s.length(); i++) {
            if(ch[s.charAt(i)-'a']==1)
            {
                System.out.println((char)(s.charAt(i)));
                break;
            }
        }
//        System.out.println("Hello");
//        //try {
//        System.out.println(ch[26]);
//        //}catch(Exception e){}
//
//        System.out.println("Thank You");
    }
}
