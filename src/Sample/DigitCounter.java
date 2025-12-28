package Sample;

import java.util.ArrayList;

public class DigitCounter {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("1234543");
        int arr[] = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int ind = Integer.parseInt(str.charAt(i)+"");
            arr[ind]++;
        }
        int e = -1;
        int count = -1;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0) {
                res.add(i);
            }
            else if(arr[i]>=count){
                e = i;
                count = arr[i];
            }
        }
        System.out.println("Most occurred digit:"+e);
        System.out.print("Digits did not occurred:");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if(i!=res.size()-1){
                System.out.print(",");
            }
        }
    }
}
