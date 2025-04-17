package Recurrsion;

public class TargetSum {
    public static void main(String[] args) {
        int arr[] = {1,1,1,1,1};
        int target = 3;
        System.out.println(targetCount(arr,target,0,0,0));
    }
    public static int targetCount(int arr[],int target,int count,int index,int current)
    {
        if(index==arr.length)
        {
            if(current==target)
                return 1;
            return 0;
        }
        current += arr[index];
        count += targetCount(arr,target,count,index+1,current);
        current -= arr[index];
        count += targetCount(arr,target,count,index+1,current);
        return count;
    }
}
