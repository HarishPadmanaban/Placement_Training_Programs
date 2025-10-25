package Sample;

import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <n ; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(isAnagram(s1,s2)?"Yes":"No");
        }
    }

    private static boolean isAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int arr[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        for(int i : arr) {
            if(i!=0) return false;
        }
        return true;
    }
}
