package SlidingWindow;

import java.util.HashMap;

public class KDistinct {
    public static void main(String[] args) {
        String s = "orvlpy";
        int k = 1;
        System.out.println(giveLen(s,k));
    }

    private static int giveLen(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length(),max = -1;
        while(j<n)
        {
            if(map.size()<=k)
            {
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                if(map.size()==k){
                    max = Math.max(j-i+1,max);
                }
                j++;
            }
            else{
                while(map.size()>k)
                {
                    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                    if(map.get(s.charAt(i))==0)
                    {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                if(map.size()==k){
                    max = Math.max((j-1)-i+1,max);
                }
                //j++;
            }
        }
        return max;
    }
}
