public class ClosestSum {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] arr = {5,-7,3,5};
        int target = 6;
        System.out.println(printAllSubSum(arr,0,0,target,Integer.MAX_VALUE));
        //System.out.println(min);
    }

    private static int printAllSubSum(int[] arr,int ind,int sum,int target,int min) {
        if(ind==arr.length){
            return min;
        }
        sum += arr[ind];
        int val = Math.abs(sum-(target));
        //System.out.println(sum+" => "+val+" => "+min);
        min = Math.min(min,val);
        System.out.println(sum+" => "+val+" => "+min);
        int v1 = printAllSubSum(arr,ind+1,sum,target,min);
        sum -= arr[ind];
        val = Math.abs(sum-(target));
        min = Math.min(min,val);
        System.out.println(sum+" => "+val+" => "+min);
        int v2 = printAllSubSum(arr,ind+1,sum,target,min);
        return Math.min(v1,v2);
    }
}
