package BinarySearch;

public class KthMissingInt {
    public static void main(String[] args) {
        int [] arr = {1,10,21,22,25};
        int k = 12;
        //System.out.println(find(arr,k));
        System.out.println(findMissingOptimized(arr,k));
    }

    private static int findMissingOptimized(int[] arr, int k) {
        int l = 0;
        int r = arr.length-1;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            int val = arr[mid]-(mid+1);
            if(val>=k){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l+k;
    }

    private static int find(int[] arr, int k) {
        int pos = 1;
        int i = 0;
        int miss = 0;
        while(true){
            if(i==arr.length) break;
            if(arr[i]==pos){
                i++;
                pos++;
            }
            else{
                miss++;
                if(miss==k){
                    return pos;
                }
                pos++;

            }
        }
        return arr[i-1]+(k-miss);
    }
}