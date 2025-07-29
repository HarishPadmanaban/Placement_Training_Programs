public class UniqueNumber {
    public static void main(String[] args) {

        int arr[] = {2,3,2,7,5,7,5,2,5,7};
        int n = 3;
        int result = 0;
        for(int i=0;i<32;i++)
        {
            int sum = 0;
            for(int j = 0;j<arr.length;j++)
            {
                if(((arr[j]>>i)&1) == 1) {
                    sum++;
                }
            }
            //System.out.print(sum+" ");
            if(sum%n !=0)
            {
                result |= (1<<i);
            }
        }
        System.out.println("\n"+result);
     }


}
