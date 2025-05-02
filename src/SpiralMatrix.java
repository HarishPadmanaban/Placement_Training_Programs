import java.util.Arrays;

public class SpiralMatrix {
    public static void main(String[] args) {
        //int arr [][] = {{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
        //int arr[][] = {{1,2},{3,4}};
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};

        int res[][] = new int[arr.length][arr[0].length];

        int val = 0;
        int top=0,left=0,right = arr[0].length-1,bottom=arr.length-1;

        while(top<=bottom)
        {
            int i = left;
            while(i<=right)
            {
                res[top][i] = ++val;
                System.out.print(arr[top][i]+" ");
                i++;
            }
            top++;
            if(top>bottom)
                break;
            System.out.print(" ");
            i = top;

            while(i<=bottom)
            {
                res[i][right] = ++val;
                System.out.print(arr[i][right]+" ");
                i++;
            }
            right--;
            System.out.print(" ");
            i = right;
            while(i>=left)
            {
                res[bottom][i] = ++val;
                System.out.print(arr[bottom][i]+" ");
                i--;
            }
            bottom--;
            System.out.print(" ");
            i = bottom;
            while(i>=top)
            {
                res[i][left] = ++val;
                System.out.print(arr[i][left]+" ");
                i--;
            }
            left++;
            System.out.print(" ");
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
