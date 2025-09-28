package BinarySearch;

public class SingleElement {
    public static void main(String[] args) {
        int nums[] ={1,1,2,3,3,4,4,7,7,8,8};
        System.out.println(binarySearch(nums,0,nums.length-1));
    }

    private static int binarySearch(int[] arr, int s, int e) {
        while(s<=e)
        {
            int mid = s+(e-s)/2;
            if(mid < e &&arr[mid]==arr[mid+1])
            {
                if((e-mid+1)%2==0)
                {
                    e = mid-1;
                }
                else{
                    s = mid+2;
                }
            }
            else if(mid>s && arr[mid]==arr[mid-1]){
                if(((e-mid-1)+1)%2==0)
                {
                    e = mid-2;
                }
                else{
                    s = mid+1;
                }
            }
            else return mid;
        }
        return -1;
    }
}
