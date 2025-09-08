import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
       // int arr [] = {3,4,7,-2,2,1,4,2};
        int arr[] = {1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        System.out.println(findCount(arr,k));
        System.out.println(findCountOptimal(arr,k));
    }

    private static int findCountOptimal(int[] arr, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int diff = prefixSum - k;
            if(map.containsKey(diff))
            {
                count+= map.get(diff);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }

    private static int findCount(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if(sum==k) count++;
            }
        }
        return count;
    }
}
