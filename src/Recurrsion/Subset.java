package Recurrsion;
import java.util.*;

public class Subset {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        //List<Integer>  al =
        subset(arr,0,new ArrayList<>());
    }
    public  static void  subset(int[] arr,int ind,List<Integer> res)
    {
        if(ind>=arr.length)
        {
            System.out.println(res);
            return;
        }
        res.add(arr[ind]);
        subset(arr,ind+1,res);
        res.remove(res.size()-1);
        subset(arr,ind+1,res);
    }

//    public static List<List<Integer>> returnList(int[] arr,int ind,List<Integer> res)
//    {
//        if(ind>=arr.length)
//        {
//            System.out.println(res);
//            return ;
//        }
//        List<Integer> curr = new ArrayList<>();
//        curr.add(arr[ind]);
//        subset(arr,ind+1,res);
//        curr.remove(res.size()-1);
//        subset(arr,ind+1,res);
//    }
}
