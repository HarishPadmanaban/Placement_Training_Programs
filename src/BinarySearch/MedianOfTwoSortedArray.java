package BinarySearch;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int []nums1 = {};
        int []nums2 = {1};
        System.out.println(findMedian(nums1,nums2));
    }

    private static double findMedian(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1) return findMedian(nums2,nums1);
        int l = 0;
        int r = nums1.length;
        int leftNeed = (n1+n2+1)/2;
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
                if((n1+n2)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/(double)2;
                }
                else{
                    return Math.max(l1,l2);
                }
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
