import java.lang.reflect.Array;
import java.util.List;
import java.util.*;
public class Subset {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        List<List<Integer>> ans = sub(arr);
        for(List<Integer> l : ans)
        {
            System.out.println(l);
        }
    }
    static List<List<Integer>> sub(int num[])
    {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int n:num)
        {
            int size = outer.size();
            for (int i = 0; i < size; i++) {
                List<Integer> al = new ArrayList<>();
                al.addAll(outer.get(i));
                al.add(n);
                if(!outer.contains(al))
                    outer.add(al);
            }
        }
        return outer;
    }
}
