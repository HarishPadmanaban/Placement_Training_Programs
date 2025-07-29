package String;

import Sorting.QuickSort;

import java.util.*;
public class Isomorphic {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //QuickSort qs = new QuickSort();
        String s1 = "badc";
        String s2 = "baba";
        if(s1.length()!=s2.length())
        {
            System.out.println("Not isomorphic");
            System.exit(0);
        }
        int []freq = new int[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = -1;
        }
        for(int i=0;i<s1.length();i++)
        {
            if(freq[s1.charAt(i)-'a']==-1)
                freq[s1.charAt(i)-'a'] = s2.charAt(i)-'a';
        }
        System.out.println(Arrays.toString(freq));
        boolean flag =true;
        for(int i=0;i<s1.length();i++)
        {
            if(freq[s1.charAt(i)-'a'] != s2.charAt(i)-'a')
            {
                System.out.println("Not String.Isomorphic");
                flag=false;
                break;
            }
        }
        if(flag)
            System.out.println("String Isomorphic");
    }
}
