package Sample;

import java.util.Scanner;

public class LetterCounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(giveCount(s.charAt(0),s));
    }

    private static String giveCount(char ch, String s) {
        int count = 0;
        for (int i =1;i<s.length();i++)
        {
            if(s.charAt(i)==ch) count++;
        }
        return ch+" occurs "+count+" times";
    }
}
