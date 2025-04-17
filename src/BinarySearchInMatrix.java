public class BinarySearchInMatrix {
    public static void main(String[] args) {
        //matrix is sorted in row wise and column wise.
        int arr[][] = {{10,20,30,40},{11,25,35,45},{28,29,37,49},{33,34,38,50}};
        int lb = 0;
        int target = 10;
        int ub=arr[0].length-1;
        boolean flag = true;
        while(lb<=ub)
        {
            if(arr[lb][ub]==target){
                System.out.println(lb+" "+ub);
                flag=false;
                break;
            }
            else if(arr[lb][ub]<target)
            {
                lb++;
            }
            else{
                ub--;
            }
        }
        System.out.println((flag)?"Not found":"");
    }
}
