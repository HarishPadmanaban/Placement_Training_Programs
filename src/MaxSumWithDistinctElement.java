import java.util.HashMap;
import java.util.HashSet;

public class MaxSumWithDistinctElement {
    public static void main(String[] args) {
        int [] arr = {3,3,5,5,3,3,1,2,6,3,5,1};
        //[1,1,1,7,8,9]
        //3
        int k = 4;
        System.out.println(maxSum(arr,k));
    }

    private static long maxSum(int[] arr, int k) {
        long sum = 0;
        long max = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0, r = 0;
        while(r<arr.length)
        {
            while((r-l+1) <= k  && r<arr.length){
                if(!map.containsKey(arr[r])){
                    sum+=arr[r];
                }
                else{
                    int m  = map.get(arr[r]);
                    map.remove(m);
                    while(l<m+1){
                        sum-=arr[l];
                        map.remove(arr[l]);
                        l++;
                    }
                    sum+=arr[r];
                }
                map.put(arr[r],r);
                if(r-l+1 == k){
                    max = Math.max(max,sum);
                }
                r++;
            }
            map.remove(arr[l]);
            sum-=arr[l++];
        }
        return max;
    }
}
