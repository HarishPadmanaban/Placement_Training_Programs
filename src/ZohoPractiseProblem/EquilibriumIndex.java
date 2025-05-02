package ZohoPractiseProblem;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int arr[] = {2,3,3,0,0,6,2};
        int ts = 0;
        for(int i:arr)
        {
            ts+=i;
        }
        int ls = arr[0];
        boolean flag = true;
        for(int i=1;i<arr.length;i++)
        {
            int rs = ts-(arr[i]+ls);
            if(rs==ls)
            {
                System.out.println(i);
                flag = false;
                break;
            }
            ls+=arr[i];
        }
        if(flag)
        {
            System.out.println("No Equilibirum index");
        }
    }
}
