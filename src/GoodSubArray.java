import java.util.HashMap;
import java.util.HashSet;

public class GoodSubArray {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int k = 1;
        System.out.println(bruteForceApproach(nums,k));
        System.out.println(optimizedApproach(nums,k) - optimizedApproach(nums,k-1));


        // exactly(k) = atmost(k) - atmost(k-1)
    }

    private static int optimizedApproach(int[] nums, int k) {
        int count = 0;
        if(k<=0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < nums.length ; j++) {
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>k)
            {
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)
                    map.remove(nums[i]);
                i++;
            }
            count += j-i+1;
        }
        return count;
    }

    private static int bruteForceApproach(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                //System.out.print(nums[j]+",");
                set.add(nums[j]);
                if(set.size()==k) {
                        count++;
                }
            }
            //System.out.println();
        }
        return count;
    }
}
