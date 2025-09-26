
public class JumpGame2 {
    public static void main(String[] args) {
        int arr[] = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
//        int count = 0;
//        int min = Integer.MAX_VALUE;
//        System.out.println(jumpgame(arr,0,count,min));
        //[5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5]
        jumpgame2(arr);
    }

    private static int jumpgame(int[] arr, int i,int count,int min) {
        if(i>=arr.length-1)
        {
            return count;
        }
        for (int j = arr[i]; j >0 ; j--) {
            min = Math.min(min,jumpgame(arr,i+j,count+1,min));
        }
        return min;
    }

    private static void jumpgame2(int arr[])
    {
        int jumps = 0;
        int l = 0, r =0;
        while (r<arr.length-1)
        {
            int farthest = r+1;
            for(int i=l;i<=r;i++)
            {
                farthest= Math.max(farthest,i+arr[i]);
            }
            l = r+1;
            r = farthest;
            //System.out.println(l+" "+r);
            jumps++;
        }
        System.out.println(jumps);
    }
}
