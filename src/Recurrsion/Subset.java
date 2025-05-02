package Recurrsion;
import java.util.*;

public class Subset {
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        //List<Integer>  al =
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        //subset(arr,0,new ArrayList<>());
        sub(arr,0,new ArrayList<>(),res);
        System.out.println(res);
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

    public static void sub(int []arr ,int ind ,List<Integer> al, List<List<Integer>> res)
    {
        res.add(new ArrayList<>(al));
        for(int i = ind;i<arr.length;i++)
        {
            if(i!=ind && arr[i]==arr[i-1])
                continue;
            al.add(arr[i]);
            sub(arr,i+1,al,res);
            al.remove(al.size()-1);
        }
    }
}
