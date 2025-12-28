package Sample;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayCommand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int c = sc.nextInt();
        ArrayList<Integer> res = new ArrayList<>();
        for (int k = 0; k < c; k++) {
            char ch = sc.next().charAt(0);
            int i = sc.nextInt();
            int j = sc.nextInt();
            int val = 0;
            if(ch=='A'){
                val = sc.nextInt();
            }
            if(ch=='A'){
                for (int l = i; l <= j; l++) {
                    arr[l] += val;
                }
            }
            else if(ch=='P'){
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l];
                }
                res.add(sum);
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
