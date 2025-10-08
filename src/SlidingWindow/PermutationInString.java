package SlidingWindow;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String pat = "adc";
        String text = "dcda";
        System.out.println(isPermutation(pat,text));
    }

    private static boolean isPermutation(String pat, String text) {
        int freq[] = new int[26];
        for (char c : pat.toCharArray()) freq[c-'a']++;
        int i = 0,j = 0,n = text.length(),ws = pat.length();
        int temp[] = new int[26];
        while(j<n)
        {
            if(j-i<ws){
                temp[text.charAt(j)-'a']++;
                j++;
                if(j==n && j==ws) return Arrays.equals(freq,temp);
            }
            else{
                if(Arrays.equals(freq,temp)) return true;
                temp[text.charAt(i++)-'a']--;
                temp[text.charAt(j++)-'a']++;
                if(j==n) return Arrays.equals(freq,temp);
            }
        }
        return false;
    }
}
