package Sample;

import java.util.Scanner;

public class MobileKeyPad {
    public static void main(String[] args) {
        String [] word = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "TUV", "WXYZ"};
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(giveResultNumber(s,word));
    }
    private static String giveResultNumber(String s, String[] word) {
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray())
        {
            for (int i = 0; i < word.length; i++) {
                if(word[i].contains(ch+"")){
                    str.append(i+2);
                    break;
                }
            }
        }
        return str.toString();
    }
}
