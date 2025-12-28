package Sample;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 2; i <n ; i++) {
            if(isPrime(arr[i])&&isPrime(i)){
                res.add(new int[]{arr[i],i});
            }
        }
        System.out.println(res.size());
        for(int[] a : res){
            System.out.println(a[0]+" "+a[1]);
        }
    }

    private static boolean isPrime(int val) {
        for (int i = 2; i <= (int)Math.sqrt(val); i++) {
            if(val%i==0) return false;
        }
        return true;
    }
}
