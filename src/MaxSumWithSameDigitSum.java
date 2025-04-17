import java.util.*;
public class MaxSumWithSameDigitSum {
    public static void main(String[] args) {
        int arr[] = {229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401};
        Arrays.sort(arr);
        System.out.println(Logic(arr));
        //System.out.println(Sum(108));
    }
    static int Logic(int arr[])
    {
        HashMap<Integer,List<Integer>> mp = new HashMap<>();
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sd = Sum(arr[i]);
            if(!mp.containsKey(sd))
            {
                mp.put(sd,new ArrayList<>());
                mp.get(sd).add(arr[i]);
                if(!al.contains(sd))
                    al.add(sd);
            }
            else {
                mp.get(sd).add(arr[i]);
            }
        }
        System.out.println(mp);
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i <al.size(); i++) {
            int sod = al.get(i);
            if(mp.get(sod).size()>=2)
            {
                int val = mp.get(sod).get(mp.get(sod).size()-1) + mp.get(sod).get(mp.get(sod).size()-2);
                sum = Math.max(val,sum);
            }
        }
        return sum;
    }
    static int Sum(int n)
    {
        int s = 0;
        while(n>0)
        {
            s+= n%10;
            n/=10;
        }
        return s;
    }
}
