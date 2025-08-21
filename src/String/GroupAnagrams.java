package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("eat","tea","tan","ate","nat","bat");
        System.out.println(group(l));
    }

    private static List<List<String>> group(List<String> l) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i=0;i<l.size();i++)
        {
            char c[] = l.get(i).toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(!map.containsKey(key))
                map.put(key,new  ArrayList<>());
            map.get(key).add(l.get(i));
        }
        System.out.println(map);
        return new ArrayList<>(map.values());
    }


}
