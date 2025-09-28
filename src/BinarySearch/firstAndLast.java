package BinarySearch;

import java.util.Arrays;

public class firstAndLast {
    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};
        int target = 10;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int [] res={-1,-1};

        //if(nums.length==0)
        // return res;

        res[0]=binary(nums,target,true);

        res[1]=binary(nums,target,false);

        return res;

    }
   static int binary(int []arr, int tar , boolean isstart)
    {
        int val=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==tar){
                val=mid;
                if(isstart){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else if(arr[mid]>tar){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return val;
    }
}
