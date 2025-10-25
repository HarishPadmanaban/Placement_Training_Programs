package Sample;

import java.util.Scanner;

public class DoubleDutch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        System.out.println(giveResultWord(sentence.split(" ")));
    }

    private static String giveResultWord(String[] arr) {
        StringBuilder str = new StringBuilder();
        for(String s : arr)
        {
            str.append(s.substring(1));
            str.append(s.charAt(0));
            str.append("ay");
            str.append(" ");
        }
        return str.toString();
    }
}
