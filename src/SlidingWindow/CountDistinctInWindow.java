package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountDistinctInWindow {
    public static void main(String[] args) {
        int [] arr = {8,10,12};
                //{1, 2, 1, 3, 4, 2, 3};
        //10 ,3 ,12 ,4 ,10 ,9 ,9 ,12 ,8 ,4 ,1 ,3 ,3 ,2 ,11 ,12 ,11 ,11
        int k = 1;
        System.out.println(countDistinct(arr,k));
    }

    private static List<Integer> countDistinct(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int i = 0,j = 0,n = arr.length;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j<n)
        {
            if(j-i+1<=k)
            {
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
                j++;
                if(j==n && j==k) result.add(map.size());
            }
            else
            {
                result.add(map.size());
                map.put(arr[i],map.getOrDefault(arr[i],0)-1);
                if(map.get(arr[i])==0) map.remove(arr[i]);
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
                i++;
                j++;
                if(j==n) result.add(map.size());
            }
        }
        return result;
    }
}
