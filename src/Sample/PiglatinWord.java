package Sample;

import java.util.Scanner;

public class PiglatinWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(giveword(s.split(" ")));
    }

    private static String giveword(String [] arr) {
        StringBuilder str = new StringBuilder();
        for(String s : arr){
            String temp = s;
            s = s.toLowerCase();
            int ind = -1;
            //int ind = (s.indexOf('a') !=-1 ? s.indexOf('a') : (s.indexOf('e') !=-1 ? s.indexOf('e') : (s.indexOf('i') !=-1 ? s.indexOf('i') :(s.indexOf('o') !=-1 ? s.indexOf('o') : (s.indexOf('u') !=-1 ? s.indexOf('u') : -1)))));
            for(int i =0;i<s.length();i++){
                char ch = s.charAt(i);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    ind = i;
                    break;
                }
            }
            if(ind==-1){
                str.append(s);
            }
            else{
                str.append(temp.substring(ind));
                str.append(temp.substring(0,ind));
                str.append("ay");
            }
            str.append(" ");
        }
        return str.toString();
    }
}
