package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWithSumK {
    public static void main(String[] args) {
        int arr[] = {1,2,4,3,5,1,1};
        int k = 4;
        List<Integer> al = new ArrayList<>();
        subWithKSum(arr,k,0,al,0);
    }

    public static void subWithKSum(int arr[], int k, int ind, List<Integer> al,int sum)
    {
        if(ind == arr.length)
        {
            if(sum==k)
            {
                System.out.println(al);
            }
            return;
        }

        al.add(arr[ind]);
        sum+=arr[ind];
        subWithKSum(arr,k,ind+1,al,sum);

        al.remove(al.size()-1);
        sum-=arr[ind];
        subWithKSum(arr,k,ind+1,al,sum);
    }

    //print only one
    public static boolean subWithKSum2(int arr[], int k, int ind, List<Integer> al,int sum)
    {
        if(ind == arr.length)
        {
            if(sum==k)
            {
                System.out.println(al);
                return true;
            }
            return false;
        }

        al.add(arr[ind]);
        sum+=arr[ind];
        if(subWithKSum2(arr,k,ind+1,al,sum))
        {
            return true;
        }

        al.remove(al.size()-1);
        sum-=arr[ind];
        if(subWithKSum2(arr,k,ind+1,al,sum))
        {
            return true;
        }
        return false;
    }
}
