import java.util.*;
public class ShuffleArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int k =5;
        int r = k;
        for(int i=1;i<=k;i+=2)
        {
            int temp = arr[r];
            int end = r;
            while(end>i)
            {
                int t = arr[end];
                arr[end] = arr[end-1];
                arr[end-1] = t;
                end--;
            }
            arr[i] = temp;
            r++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
