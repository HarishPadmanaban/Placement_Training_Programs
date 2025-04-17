package String;

import java.util.*;
public class Reverse {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = "python java python html python";
        String result = "";
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            result = result + rev(arr[i])+" ";
        }
        System.out.println(result);
    }
    public static String rev(String w)
    {
        String res = "";
        for (int i = w.length()-1; i >=0 ; i--) {
            res = res+w.charAt(i);
        }
        return res;
    }
}
