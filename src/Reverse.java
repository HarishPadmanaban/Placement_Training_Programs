import java.util.Arrays;

public class Reverse{
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        reverseInPlace(arr);
        //System.out.println(Arrays.toString(reverse(arr)));
    }
    public static void reverseInPlace(int arr[])
    {
        int i=0;
        int j= arr.length-1;
        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] reverse(int arr[])
    {
        int res[] = new int[arr.length];
        int k=0;
        for(int i=arr.length-1;i>=0;i--)
        {
            res[k] = arr[i];
            k++;
        }
        return res;
    }
}
