package BinarySearch;

public class KthElementIn2SortedArray {
    public static void main(String[] args) {
        int []nums1 = {2,3,4,5};
        int []nums2 = {4,6,7,8};
        int k = 2;
        System.out.println(findK(nums1,nums2,k));
    }

    private static double findK(int[] nums1, int[] nums2,int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1) return findK(nums2,nums1,k);
        int l = Math.max(0,k-n2);
        int r = Math.min(k,n1);
        int leftNeed = k;
        while(l<=r)
        {
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            int mid1 = l+(r-l)/2;
            int mid2 = leftNeed-mid1;
            if(mid1<n1) r1 = nums1[mid1];
            if(mid2<n2) r2 = nums2[mid2];
            if(mid1-1>=0) l1 = nums1[mid1-1];
            if(mid2-1>=0) l2 = nums2[mid2-1];
            if(l1<r2 && l2<r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                r = mid1-1;
            }
            else{
                l = mid1+1;
            }
        }
        return -1;
    }
}
