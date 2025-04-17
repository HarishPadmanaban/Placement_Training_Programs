import java.util.*;
public class PrimeGeneration {
    public static void main(String[] args) {
        int left = 19;
        int right = 31;
        List<Integer> li = new ArrayList<>();
        boolean flag = true;
        for(int j = left;j<=right;j++){
            for(int i=2;i<=Math.sqrt(j);i++)
            {
                if(j%i==0)
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                li.add(j);
            flag = true;
        }
        System.out.println(li);
    }
}
