package PresumHashMapPattern;

import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int [] arr = {1,1,0,0,1,1,0,1,1};
        System.out.println(findArray(arr));
    }

    private static int findArray(int[] arr) {
        int sum = 0;
        int size = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0) sum-=1;
            else sum+=1;

            if(sum==0)
            {
                size = Math.max(size,i+1);
            }
            else if(map.containsKey(sum)){
                int ind = map.get(sum);
                size = Math.max(size,i-ind);
            }
            else{
                map.put(sum,i);
            }
        }
        return size;
    }
}
