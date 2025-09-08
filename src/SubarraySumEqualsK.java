public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int arr [] = {3,4,7,-2,2,1,4,2};
        int k = 7;
        System.out.println(findCount(arr,k));
    }

    private static int findCount(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if(sum==k) count++;
            }
        }
        return count;
    }
}
