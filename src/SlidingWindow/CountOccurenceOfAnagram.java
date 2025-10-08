package SlidingWindow;

import java.util.Arrays;

public class CountOccurenceOfAnagram {
    public static void main(String[] args) {
        String s1 = "aaba";
        String s2 = "aabaabaa";
        //Input: txt = "forxxorfxdofr", pat = "for"
        System.out.println(Count(s1,s2));
    }
    private static int Count(String pat, String text) {
        int freq[] = new int[26];
        for (char c : pat.toCharArray()) freq[c-'a']++;
        int i = 0,j = 0,n = text.length(),ws = pat.length();
        int temp[] = new int[26];
        int count = 0;
        while(j<n)
        {
            if(j-i<ws){
                temp[text.charAt(j)-'a']++;
                j++;
                if(j==n && j==ws) {
                    count++;
                }
            }
            else{
                if(Arrays.equals(freq,temp)) {
                    count++;
                }
                temp[text.charAt(i++)-'a']--;
                temp[text.charAt(j++)-'a']++;
                if(j==n && Arrays.equals(freq,temp)) {
                    count++;
                }
            }
        }
        return count;
    }
}
