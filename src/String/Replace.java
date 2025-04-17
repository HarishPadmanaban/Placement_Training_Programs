package String;

import java.util.*;
public class Replace {
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        String s = "python java python html python";
        String s1 = "python";
        String result="";
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].equals("python"))
                arr[i] = "c++";
            result = result+arr[i];
            result = result+" ";
        }
        System.out.println(result);
    }
}
