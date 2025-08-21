import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Frequencies {
    public static void main(String[] args) {
        String s = "GeeksforGeeks";
        printFreq(s.toLowerCase());
        printFreq2(s.toLowerCase());
    }

    public static void printFreq(String s)
    {
        HashMap<Integer,List<Character>> map = new HashMap<>();
        List<Integer> ind = new ArrayList<>();
        int arr[] = new int[26];
        for(char c : s.toCharArray())
        {
            arr[c-'a']++;
        }
        System.out.println(Arrays.toString(arr));
        for(char c:s.toCharArray()){
            if(arr[c-'a']!=-1){
                System.out.println(c+"=>"+arr[c-'a']);
                if(!map.containsKey(arr[c-'a'])){
                    map.put(arr[c-'a'],new ArrayList<>());
                    map.get(arr[c-'a']).add(c);
                    ind.add(arr[c-'a']);
                }
                else{
                    map.get(arr[c-'a']).add(c);
                }
                arr[c-'a'] = -1;
            }
        }
        System.out.println(map);
        int n = ind.size();
        for (int i = 0; i < n; i++) {
            int maxInd = -1;
            int indOfInd = -1;
            for (int j = 0; j < ind.size(); j++) {
                if(maxInd<ind.get(j))
                {
                    maxInd = ind.get(j);
                    indOfInd = j;
                }
            }
            List<Character> chList = map.get(maxInd);
            for(int k=chList.size()-1;k>=0;k--)
            {
                System.out.println(chList.get(k));
            }
            map.remove(maxInd);
            ind.remove(indOfInd);
        }
    }

    public static void printFreq2(String s)
    {
        int arr[] = new int[26];
        for(char c : s.toCharArray())
        {
            arr[c-'a']++;
        }
        System.out.println(Arrays.toString(arr));
        List<Character>[] chList = new List[s.length()+1];
        for (int i = 0; i < chList.length; i++) {
            chList[i] = new ArrayList<>();
        }
        for (int i = 0; i < 26; i++) {
            if(arr[i]>0){
                chList[arr[i]].add(0,(char)('a'+i));
            }
        }
        //System.out.println(Arrays.toString(chList));
        for (int i = chList.length-1; i>= 0; i--) {
            if(!chList[i].isEmpty()){
                for (int j = 0; j < chList[i].size(); j++) {
                    System.out.println(chList[i].get(j)+" - "+i);
                }
            }
        }
    }
}
