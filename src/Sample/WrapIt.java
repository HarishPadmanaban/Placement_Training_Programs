package Sample;

import java.util.Scanner;

public class WrapIt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder result = new StringBuilder();
        int i = 1;
        int n = s.length();
        while(i<n){
            int count = 1;
            while(i<n && s.charAt(i)==s.charAt(i-1)){
                count++;
                i++;
            }
            if(count==1){
                result.append(s.charAt(i-1));
                i++;
            }
            else{
                result.append(count);
            }
            if(i==n){
                result.append(s.charAt(i-1));
            }
        }
        System.out.println(result);
    }
}
