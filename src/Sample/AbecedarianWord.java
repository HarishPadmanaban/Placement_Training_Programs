package Sample;

import java.util.Arrays;
import java.util.Scanner;

public class AbecedarianWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String sentence = sc.nextLine();
        String [] arr = sentence.split(",");
        int res[] = new int[n];
        for (int i = 0; i <n ; i++) {
            char [] ch = arr[i].toCharArray();
            Arrays.sort(ch);
            if(arr[i].equals(new String(ch))){
                res[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i]);
            if(i!=n-1) System.out.print(",");
        }
        //System.out.println(Arrays.toString(res));
    }
}
