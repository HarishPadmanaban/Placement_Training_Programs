package Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Roorim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> result = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = sc.nextInt();
                arr[j] = reverse(arr[j]);
            }
            Arrays.sort(arr);
            result.add(arr);
            //System.out.println(Arrays.toString(arr));
        }
        for (int i = 0; i < result.size(); i++) {
            int [] temp = result.get(i);
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[j]);
                if(j!=temp.length-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }

    private static int reverse(int i) {
        int res = 0;
        while(i>0){
            res = (res*10)+(i%10);
            i/=10;
        }
        return res;
    }
}
