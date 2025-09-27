import java.util.Arrays;

public class CountInversion {
    //static int count = 0;
    public static void main(String[] args) {

        //10
        //52244275 123047899 493394237 922363607 378906890 188674257 222477309 902683641 860884025 339100162

        long []arr = {52, 123, 493, 922 ,378 ,188 ,222 ,902 ,860 ,339};
        System.out.println(Arrays.toString(arr));
        System.out.println(mergeSort(arr,0,arr.length));

       // System.out.println(count);
    }

    private static int mergeSort(long[] arr, int s, int e) {
        int count = 0;
        if(e-s > 1){
            int mid = (s+e)/2;
            int c = 0;
            count+= mergeSort(arr,s,mid);
            count+=mergeSort(arr,mid,e);
            c+= merge(arr,s,mid,e);
            System.out.println(c+" "+count);
            return c+count;
        }
        return count;
    }

    private static int merge(long[] arr, int s, int mid, int e) {
        int i = s;
        int j = mid;
        long []res = new long[e-s];
        int k = 0;
        int count = 0;
        while(i<mid && j<e)
        {
            if(arr[i]<=arr[j]){
                res[k++] = arr[i++];
            }
            else{
                count+=(mid-i);
                res[k++] = arr[j++];
            }
        }

        while(i<mid){
            res[k++] = arr[i++];
        }
        while(j<e) {

            res[k++] = arr[j++];
        }

        for(int m = 0;m< res.length;m++)
        {
            arr[m+s] = res[m];
        }
        return count;
    }
}
