import java.util.*;

public class CountOfSmallerAfterSelf {
    public static void main(String[] args) {
        int[] arr = {11,7,5,8,12,9};
        System.out.println(countSmaller(arr));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        List<Integer> li = new ArrayList<>();

        for(int i=nums.length-1;i>=0;i--)
        {
            int ind = search(sorted,nums[i]);
            li.add(ind);
            sorted.add(ind,nums[i]);
        }
        Collections.reverse(li);
        return li;
    }
    private static int search(List<Integer> list, int num) {
        int l = 0;
        int r = list.size()-1;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(list.get(mid) < num)
            {
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return l;
    }
}
