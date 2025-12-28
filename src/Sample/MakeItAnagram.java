package Sample;

import java.util.HashMap;
import java.util.Scanner;

public class MakeItAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String res1 = "";
        String res2 = "";
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (char ch : s1.toCharArray()) map1.put(ch,map1.getOrDefault(ch,0)+1);
        for (char ch : s2.toCharArray()) map2.put(ch,map2.getOrDefault(ch,0)+1);
        for(char ch : s1.toCharArray()){
            if(!map2.containsKey(ch)){
                res1 += ch;
            }
            else{
                int a = map1.get(ch);
                int b = map2.get(ch);
                if(a>b){
                    res1 += ch;
                    map1.put(ch,map1.get(ch)-1);
                }
            }
        }
        System.out.println(res1);
        for(char ch : s2.toCharArray()){
            if(!map1.containsKey(ch)){
                res2 += ch;
            }
            else{
                int a = map1.get(ch);
                int b = map2.get(ch);
                if(b>a){
                    res2 += ch;
                    map2.put(ch,map2.get(ch)-1);
                }
            }
        }
        System.out.println(res2);
        System.out.println(res1.length()+res2.length());
    }
}
