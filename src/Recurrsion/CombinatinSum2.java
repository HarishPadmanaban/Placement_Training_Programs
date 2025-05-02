package Recurrsion;
import java.util.*;
public class CombinatinSum2 {
    public static void main(String[] args) {
        int []candidates = {2,2,1,1};
        Arrays.sort(candidates);
        int target = 4;
        List<List<Integer>> res = new ArrayList<>();
        combSum(candidates,0,target,new ArrayList<>(),res);
        System.out.println(res);
    }
    public static void combSum(int []candidates ,int ind ,int target,List<Integer> al, List<List<Integer>> res)
    {
        if(target==0) {
            res.add(new ArrayList<>(al));
            return;
        }
        //al.add(candidates[ind]);
        for(int i = ind;i<candidates.length;i++)
        {
            if(i>ind && candidates[i]==candidates[i-1])
                continue;
            if(candidates[i]>target)
                break;
            al.add(candidates[i]);
            combSum(candidates,i+1,target-candidates[i],al,res);
            al.remove(al.size()-1);
        }
    }
}
