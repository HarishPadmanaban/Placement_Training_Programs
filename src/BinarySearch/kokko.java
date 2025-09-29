package BinarySearch;

public class kokko {
    public static void main(String[] args) {
        int nums[] = {3,6,7,11};
        int max = -1;
        for(int n : nums){
            max = Math.max(max,n);
        }
        int h = 8;
        System.out.println(findMinK(nums,1,max,h));
    }

    private static int findMinK(int[] nums,int l ,int r,int h) {
        int min = Integer.MAX_VALUE;
        while(l<=r)
        {
            int count = 0;
            int mid = l+(r-l)/2;
            for (int i = 0; i < nums.length; i++) {
                count += Math.ceil((double)nums[i]/(double)mid);
            }
            if(count<=h){
                min = Math.min(min,mid);
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return min;
    }
}
