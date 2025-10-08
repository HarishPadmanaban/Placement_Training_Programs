public class BinarySearchInMatrix {
    public static void main(String[] args) {
        //matrix is sorted in row wise and column wise.
        int arr[][] = {{1},{3},{5}};
        int lb = 0;
        int target = 5;
        int ub=arr[0].length-1;
        boolean flag = true;
        while(lb<=ub && lb<arr.length && ub>=0)
        {
            if( arr[lb][ub]==target){
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
