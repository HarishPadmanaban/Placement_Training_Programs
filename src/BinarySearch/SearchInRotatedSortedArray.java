package BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int target = 2;
        int peak = findPeak(arr);
        System.out.println(peak);
        if(peak==-1){
            System.out.println(binarySearch(arr,0,arr.length-1,target));
        }
        else if(target<arr[0]){
            System.out.println(binarySearch(arr,peak+1,arr.length-1,target));
        }
        else{
            System.out.println(binarySearch(arr,0,peak,target));
        }
    }

    private static int binarySearch(int[] arr, int s, int e,int target) {
        while(s<=e)
        {
            int mid = s+(e-s)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) e = mid-1;
            else s = mid+1;
        }
        return -1;
    }

    private static int findPeak(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        while(l<=r)
        {
            if(l<r && arr[l]==arr[l+1]){
                l++;
                continue;
            }
            if(r>l && arr[r]==arr[r-1]){
                r--;
                continue;
            }
            int mid = l+(r-l)/2;
            if(mid<r && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if (mid>l && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            else if(arr[mid]<=arr[l]){
                r = mid-1;
            }
            else if (arr[mid]>=arr[l]){
                l = mid+1;
            }
        }
        return -1;
    }
}
