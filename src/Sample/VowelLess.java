package Sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VowelLess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        //System.out.println(giveVowelLessCount(s));
        List<Integer> list = giveVowelLessCount(s);

        //Count Vowel less word
        int count = 0;
        for(int i =0;i<list.size()-1;i++){
            int a = list.get(i);
            int b = list.get(i+1);
            count += (b-a==1) ? 0 : 1;
            if((i==list.size()-2) && ((s.length()-1)-b>0)){
                count++;
            }
        }
        System.out.println(count);


        //From here => Longest Vowel less Word
        int max = Integer.MIN_VALUE;
        String res = "";
        for(int i =0;i<list.size()-1;i++){
            int a = list.get(i);
            int b = list.get(i+1);
            if(b-a+1 > max){
                res = s.substring(a+1,b);
                max = b-a+1;
            }
            if((i==list.size()-2) && (((s.length()-1)-b+1)>max)){
                res = s.substring(b+1);
            }
        }
        System.out.println(res);
    }

    private static List<Integer> giveVowelLessCount(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i =0 ;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' ||ch=='u'){
                list.add(i);
            }
        }
        return list;
    }
}
