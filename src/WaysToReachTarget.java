import java.util.HashMap;

public class WaysToReachTarget {
    static int count = 0;
    public static void main(String[] args) {
        int [] nums = {1,1,1,1};
        int t = 3;
        bruteForce(nums,t,0,0);
        HashMap<String,Integer> memoMap = new HashMap<>();
        int ans = memoApproch(nums,t,0,0,memoMap);
        System.out.println(ans);
        System.out.println(count);
    }

    private static int memoApproch(int[] nums, int t, int ind, int sum, HashMap<String, Integer> memoMap) {
        if(ind >= nums.length || sum > t)
            return 0;
        sum += nums[ind];
        if(sum==t && ind==nums.length-1)
            return 1;
        String key = ind +","+sum;
        if(memoMap.containsKey(key))
            return memoMap.get(key);
        int v1 = memoApproch(nums, t, ind+1, sum, memoMap);
        int v2 = memoApproch(nums, t, ind+2, sum, memoMap);
        int res = v1 + v2;
        memoMap.put(key,res);
        return res;
    }

    private static void bruteForce(int[] nums, int t, int ind,int sum) {
        if(ind>=nums.length)
            return;
        sum += nums[ind];
        if(sum==t && ind==nums.length-1){
            count++;
            return;
        }
        bruteForce(nums,t,ind+1,sum);
        bruteForce(nums,t,ind+2,sum);
    }


}
