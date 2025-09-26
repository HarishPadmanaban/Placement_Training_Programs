import java.util.ArrayList;
import java.util.HashMap;

public class ContainerWithMostWater {
    public static void main(String[] args) {
      int arr[] = {1,8,6,2,5,4,8,3,7};
        //int arr[] = {8,7,2,1};
        //int arr[] = {0,1,0};
//
//        int max = -1;
//
//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = i+1; j <arr.length ; j++) {
//                int height = Math.min(arr[i],arr[j]);
//                int water = height * (j-i);
//                max = Math.max(max,water);
//            }
//        }
        System.out.println(optimized(arr));
        //System.out.println(contiguousSubarray(arr));
    }
    public static int optimized(int[] arr)
    {
        int max = -1;
        int l = 0;
        int r = arr.length-1;

        while(l<r)
        {
            int height = Math.min(arr[l],arr[r]);
            int water = height * (r-l);
            max = Math.max(max,water);
            if(arr[l]<arr[r])
            {
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }
    public static int contiguousSubarray(int nums[])
    {
        int sum = 0;
        int size = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) sum-=1;
            else sum+=1;
//            if(sum==0)
//            {
//                size = Math.max(size,i);
//            }
            if(map.containsKey(sum))
            {
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
