package Sample;

import java.util.Scanner;

public class Sandwich {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(giveAnswer(s));
    }

    private static String giveAnswer(String s) {
        int i = 0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                if(i==0)
                    return "Invalid String";
                else{
                    return s.substring(i,j+1);
                }
            }
        }
        return "";
    }
}
